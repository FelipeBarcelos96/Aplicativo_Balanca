/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.control;

import br.com.sankhya.ConnUtils.VerificadorDeBalanca;
import br.com.sankhya.utils.ManipuladorDePropriedades;
import br.com.sankhya.view.BotaoView;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class PainelControle {
    public Boolean isConectado;
    private BotaoView botao;
    private String balanca;
    public Boolean isAmbienteTeste;
    
    public PainelControle(Boolean isAmbienteTeste) {
        this.botao = new BotaoView(isAmbienteTeste, this);        
        this.balanca = botao.getBalancaComboBox().getSelectedItem().toString();
        this.isConectado=Boolean.FALSE;
        this.isAmbienteTeste = isAmbienteTeste;  
        try {
            this.botao.getJcbCOM().setSelectedItem("COM"+ManipuladorDePropriedades.getProp().getProperty("comn"));
        } catch (IOException ex) {
            new JOptionPane().showMessageDialog(new JFrame(),"Configurações de Porta Serial não encontradas, certifique-se de que a propriedade comn existe no arquivo .properties","Erro",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PainelControle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getBalanca() {
        return balanca;
    }    

    public void setBalanca(String balanca) {
        this.balanca = balanca;
    }    
    
    public void conectar(){
    	if(this.isConectado) {
    		this.botao.getJb().setText("Conectar");
    		this.isConectado=Boolean.FALSE;
    		this.botao.getJcbCOM().setEnabled(true);
    		//  jcbCOM.setEditable(true);
    		//jcbCOM.setVisible(true);
    		//this.jcbCOM.setOpaque(true);
    	}else {
    		this.botao.getJb().setText("Desconectar");
    		isConectado=Boolean.TRUE;                                
    		this.botao.getJcbCOM().setEnabled(false);
    		//  this.jcbCOM.setEditable(false);
    		//jcbCOM.setVisible(false);
    		// this.jcbCOM.setOpaque(false);

    		if(null != this.botao.getJcbCOM().getSelectedItem()){
    			VerificadorDeBalanca.getInstance().verificarBalanca(isAmbienteTeste,
    					this.botao.getCaixa(),
    					this.botao.getJcbCOM().getSelectedItem().toString(),
    					//this.botao.getBalancaComboBox().getSelectedItem().toString()
    					this.getBalanca()
    					);
    		}else{
    			//("Sem Balança Conectada!!!").setVisible(true);                            
    			new JOptionPane().showMessageDialog(new JFrame(),"Sem Balança Detectada!","Aviso",JOptionPane.WARNING_MESSAGE);
    		}                       
    	}
    }
    
    public void salvarPortaSerialSelecionada(String comn){
        //BigDecimal port = new BigDecimal(Integer.parseInt(comn));
       //if(null != this.botao.getJcbCOM()){
       // port = new BigDecimal(this.botao.getJcbCOM().getSelectedItem().toString().substring(2));
        try {
            Properties prop = ManipuladorDePropriedades.getProp();
            prop.setProperty("comn", comn);
            ManipuladorDePropriedades.saveProps(prop);            
        } catch (IOException ex) {
            new JOptionPane().showMessageDialog(new JFrame(),"Configurações de Porta Serial não encontradas, certifique-se de que a propriedade comn existe no arquivo .properties","Erro",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PainelControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        //}
    }        
}
