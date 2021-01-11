/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.control;

import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.sankhya.utils.ManipuladorArquivo;
import br.com.sankhya.utils.ManipuladorDePropriedades;
import br.com.sankhya.view.FormulasView;

/**
 *
 * @author felip
 */
public class FormulasControle {
    private FormulasView view;

    @SuppressWarnings("static-access")
	public FormulasControle() {
    	this.view = new FormulasView();
    	this.view.setControle(this);
    	try {
			this.view.getBaudrateComboBox().setSelectedItem(Integer.toString(ManipuladorDePropriedades.getBaudrate()));
			this.view.getDatabitsComboBox().setSelectedItem(Integer.toString(ManipuladorDePropriedades.getDataBits()));
			this.view.getFormulaTextArea().setText(ManipuladorArquivo.getInstance().leitor(ManipuladorDePropriedades.getProp().getProperty("funcao")));
		} catch (NumberFormatException e) {
			new JOptionPane().showMessageDialog(new JFrame(),"Configurações Inválidas, favor revisar as Configurações!","Erro",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (IOException e) {
			new JOptionPane().showMessageDialog(new JFrame(),"Configurações não encontradas, favor revisar as Configurações!","Erro",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
        this.view.setVisible(true);
    	
    }    
    
    public void salvar() {
    	try {
    		Properties props = ManipuladorDePropriedades.getProp();
    		props.setProperty("baudrate", this.view.getBaudrateComboBox().getSelectedItem().toString());
    		props.setProperty("databits", this.view.getDatabitsComboBox().getSelectedItem().toString());
    		ManipuladorDePropriedades.saveProps(props);
			ManipuladorArquivo.getInstance().escritor(ManipuladorDePropriedades.getProp().getProperty("funcao"), this.view.getFormulaTextArea().getText());
		} catch (IOException e) {
			new JOptionPane().showMessageDialog(new JFrame(),"Configurações não encontradas, favor revisar as Configurações!","Erro",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
    }
}
