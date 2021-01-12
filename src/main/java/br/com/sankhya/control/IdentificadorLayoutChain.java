/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.control;

import br.com.sankhya.ConnUtils.VerificadorDeDigitos;
import br.com.sankhya.scriptUtils.ManipuladorDeJavaScripts;
import br.com.sankhya.utils.ManipuladorArquivo;
import br.com.sankhya.utils.ManipuladorDePropriedades;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public final class IdentificadorLayoutChain {

	public static List<BigDecimal> IdentificaLayout(String balanca, String bruta){
		int inicio; 
		int fim;


		List<BigDecimal> pesos = new ArrayList<BigDecimal>();

		String linhas = bruta;
		String array[] = new String[100];

		if(balanca == "Marca"){  

			array = linhas.split("\n");
			for(String linha:array) {

				if(linha.contains("G") && linha.contains("K")) {
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
		}else if(balanca == "Toledo 8540") {
			//new JOptionPane().showMessageDialog(new JFrame(),"Layout Não Suportado ainda","Aviso",JOptionPane.WARNING_MESSAGE);
			
			array = linhas.split(" ");
			String pedacao;
				for(String linha:array) {

					if(linha.contains("i") && linha.length() > 6/* && (!linha.contains("v") && !linha.contains("w") && !linha.contains("u") )*/) {
						inicio = 0;
						fim = VerificadorDeDigitos.getInstance().ultimoDigito(linha);//linha.indexOf("i");

						System.out.println("inicio divisao string");
						
						//new JOptionPane().showMessageDialog(new JFrame(),linha,"DEBUG!",JOptionPane.WARNING_MESSAGE);
						if(((fim-6) - inicio) != 0)
						pedacao = linha.substring(inicio, fim-6);
						else
							pedacao = null;
					//	System.out.print("Pedaço: "+pedacao);
					//	System.out.print("inicio: "+Integer.toString(inicio));
					//	System.out.print("Fim: "+Integer.toString(fim-6));
				
						//new JOptionPane().showMessageDialog(new JFrame(),pedacao,"DEBUG!",JOptionPane.WARNING_MESSAGE);
						
						System.out.println("fim divisao string");
						if(null != pedacao) {
							System.out.print(pedacao);

							if(VerificadorDeDigitos.getInstance().isDigit(pedacao)) {
								pesos.add(new BigDecimal(pedacao));
							}else {
								System.out.println("Não numero");
								//pesos.add(new BigDecimal(-1));
							}
						}
					}
					else {
						System.out.println("Não numero");
						//pesos.add(new BigDecimal(-1));
					}
					/*
					if(linha.contains("i") && (linha.contains("v") || linha.contains("w") || linha.contains("u"))) {
						i++;
						inicio = 0;
						fim = VerificadorDeDigitos.getInstance().ultimoDigito(linha);

						System.out.println("inicio divisao string");

						String pedacao= linha.substring(inicio, fim-6);
						System.out.println("fim divisao string");
						System.out.print(pedacao);

						if(VerificadorDeDigitos.getInstance().isDigit(pedacao)) {
							pesos.add(new BigDecimal(pedacao));
						}else {
							System.out.println("Não numero");
						}
					}
					*/
				}
				
				return pesos;			
		}else if(balanca == "Toledo 820") {
			new JOptionPane().showMessageDialog(new JFrame(),"Layout Não Suportado ainda","Aviso",JOptionPane.WARNING_MESSAGE);
			return null; 
		}else if(balanca == "Default") {
                    try {                    	
                        String valores = ManipuladorDeJavaScripts.getInstance().executaScript(ManipuladorArquivo.getInstance().leitor(ManipuladorDePropriedades.getProp().getProperty("funcao")), bruta);
                       // System.out.println("DEBUG!: "+valores);
                        array = valores.split(",");
                        for(String peso : array){
                            pesos.add(new BigDecimal(Integer.parseInt(peso)));
                        }
                    } catch (IOException ex) {
                        new JOptionPane().showMessageDialog(new JFrame(),"Configurações não encontradas, favor revisar as Configurações!","Erro",JOptionPane.ERROR_MESSAGE);
                        Logger.getLogger(IdentificadorLayoutChain.class.getName()).log(Level.SEVERE, null, ex);
                    }
			return pesos; 
	    }else{
			new JOptionPane().showMessageDialog(new JFrame(),"Nenhum Layout Selecionado!","Aviso",JOptionPane.WARNING_MESSAGE);
			return null; 
		}
	}        
}
