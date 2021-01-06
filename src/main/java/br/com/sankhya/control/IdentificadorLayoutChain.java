/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.control;

import br.com.sankhya.ConnUtils.VerificadorDeDigitos;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		}else if(balanca == "Toledo 8540") {
			//new JOptionPane().showMessageDialog(new JFrame(),"Layout Não Suportado ainda","Aviso",JOptionPane.WARNING_MESSAGE);
			
			array = linhas.split("\n");
				int i = 0;
				for(String linha:array) {

					if(linha.contains("i") && (!linha.contains("v") && !linha.contains("w") && !linha.contains("u") )) {
						i++;
						inicio = 0;
						fim = linha.indexOf("i");

						System.out.println("inicio divisao string");

						String pedacao= linha.substring(inicio, fim-6);
						System.out.println("fim divisao string");
						System.out.print(pedacao);

						if(VerificadorDeDigitos.getInstance().isDigit(pedacao)) {
							pesos.add(new BigDecimal(pedacao));
						}else {
							System.out.println("Não numero");
							pesos.add(new BigDecimal(-1));
						}
					}
					
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
				}
				return pesos;			
		}else if(balanca == "Toledo 820") {
			new JOptionPane().showMessageDialog(new JFrame(),"Layout Não Suportado ainda","Aviso",JOptionPane.WARNING_MESSAGE);
			return null; 
		}else{
			new JOptionPane().showMessageDialog(new JFrame(),"Nenhum Layout Selecionado!","Aviso",JOptionPane.WARNING_MESSAGE);
			return null; 
		}
	}        
}
