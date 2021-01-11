/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.ConnUtils;


/**
 *
 * @author felip
 */
public class VerificadorDeDigitos {
    private static VerificadorDeDigitos INSTANCE;
    
    private void VerificadorDeDigitos(){
        
    }    
    
    public static VerificadorDeDigitos getInstance(){
        if(INSTANCE == null)
            INSTANCE = new VerificadorDeDigitos();
        
        return INSTANCE;
    }
    
    public boolean isDigit(String s) {
	     for (int i = 0; i < s.length(); i++) {
	           char ch = s.charAt(i);
	           if (ch < 48 || ch > 57)
	                return false;
	     }
	     return true;
}
    
 public int ultimoDigito(String s) {
	     for (int i = 0; i < s.length(); i++) {
	           char ch = s.charAt(i);
	           if (ch < 48 || ch > 57)
	        	   
	                return i-1;
	     }
	     return -1;
}
    
}
