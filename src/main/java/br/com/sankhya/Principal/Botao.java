/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.Principal;

import br.com.sankhya.control.PainelControle;

/**
 *
 * @author felip
 */
public class Botao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	//Boolean teste = Boolean.FALSE;
    	Boolean teste = Boolean.FALSE;

    	for(String arg : args) {
    		if(arg.toString().contains("test")){
    			teste = Boolean.TRUE;
    		}
    	}
   
    	new PainelControle(teste);    	
    }

}
