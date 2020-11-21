/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.Principal;

import br.com.sankhya.view.BotaoView;
import br.com.sankhya.view.TesteDialog;

/**
 *
 * @author felip
 */
public class Botao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BotaoView frame = new BotaoView();
        new TesteDialog(frame, true).setVisible(true);
        frame.setVisible(true);
    }
    
}
