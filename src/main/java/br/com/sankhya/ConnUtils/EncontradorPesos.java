/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.ConnUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author felip
 */
public class EncontradorPesos {
    private static EncontradorPesos INSTANCE;
    
    private void EncontradorPesos(){
        
    }    
    
    public static EncontradorPesos getInstance(){
        if(INSTANCE == null)
            INSTANCE = new EncontradorPesos();
        
        return INSTANCE;
    }
    
    public List<BigDecimal> pesosEncontrados(String bruta){
	
    int inicio; 
    int fim;
    
  
    List<BigDecimal> pesos = new ArrayList<BigDecimal>();
 
    String linhas = bruta;
    String array[] = new String[100];

    array = linhas.split("\n");
    int i = 0;
    for(String linha:array) {
    	
    	if(linha.contains("G") && linha.contains("K")) {
  	   i++;
  	      inicio = linha.indexOf("G");
	      fim = linha.lastIndexOf("K");
	      
	      System.out.println("inicio divisao string");
	      
	      String pedacao= linha.substring(inicio + 4, fim-2);
	      System.out.println("fim divisao string");
	      System.out.print(pedacao);
	      
	      if(VerificadorDeDigitos.getInstance().isDigit(pedacao)) {
	    	  pesos.add(new BigDecimal(pedacao));
	      }else {
	    	  System.out.println("Não numero");
	      }
    	}
    }
	
	return pesos;
}
}
