/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.SwingUtils;

import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Felps
 */
public class ManipuladorDeComboBox {
    
    private ManipuladorDeComboBox() {
    }
    
    public static ManipuladorDeComboBox getInstance() {
        return ManipuladorDeComboBoxHolder.INSTANCE;
    }
    
    private static class ManipuladorDeComboBoxHolder {

        private static final ManipuladorDeComboBox INSTANCE = new ManipuladorDeComboBox();
    }
    
    public void limpaItens(JComboBox<String> jcb){
            jcb.removeAllItems();                    
    }
    
    public void listaItens(ArrayList<String> itens ,JComboBox<String> jcb){
            jcb.removeAllItems();
            for(String item : itens){
                jcb.addItem(item);
            }
    }
}
