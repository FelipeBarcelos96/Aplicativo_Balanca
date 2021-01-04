/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.ConnUtils;

import javax.swing.JTextArea;

/**
 *
 * @author felip
 */
public class VerificadorDeBalanca {
    
    private VerificadorDeBalanca() {
    }
    
    public static VerificadorDeBalanca getInstance() {
        return VerificadorDeBalancaHolder.INSTANCE;
    }
    
    private static class VerificadorDeBalancaHolder {

        private static final VerificadorDeBalanca INSTANCE = new VerificadorDeBalanca();
    }
    
    public void verificarBalanca(Boolean isAmbienteTeste, JTextArea caixa, String comn) {
		
		new Thread(new Runnable() { 
			@Override public void run() { 
				PublicadorServidor.publicaServidor(isAmbienteTeste, caixa, comn);
				//consutaSerial();
			} }).start();
		
 
	}
}
