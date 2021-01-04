/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.ConnUtils;

import br.com.sankhya.control.IdentificadorLayoutChain;
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
    
    public List<BigDecimal> pesosEncontrados(String bruta, String balanca){
	
    
	
	return IdentificadorLayoutChain.IdentificaLayout(balanca, bruta);
}
}
