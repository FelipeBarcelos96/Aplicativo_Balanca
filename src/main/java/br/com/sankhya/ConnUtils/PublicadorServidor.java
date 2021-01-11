/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.ConnUtils;

import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author felip
 */
public final class PublicadorServidor {
    
    private static ServerSocket servidor;
        
    public static void publicaServidor(Boolean isAmbienteTeste, JTextArea caixa, String comn, String balanca) {
		    try {
		      // Instancia o ServerSocket ouvindo a porta 12345
                      if(null == servidor)
		       servidor = new ServerSocket(12345);
                      
		      System.out.println("Servidor publicado na porta "+Integer.toString(servidor.getLocalPort()));           
		      	
		      
		      if(isAmbienteTeste){
		    	  String bruta;

		    	  if(balanca == "Marca"){

		    		 bruta = "ST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG";     	    	  

		    	  }else if(balanca == "Toledo 8540") {
		    		   /*bruta = "00130000000i0"
		    				  + "\n00130000000i0"
		    				  + "\n00130000000i0"
		    				  + "\n15390000000vi0"
		    				  + "\n15390000000wi0"
		    				  + "\n15390000000zi0";	*/
		    		  // bruta = "000000000si0  14880000000si0  148800000";
		    		 bruta = "i0 14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14900000000zi0  14910000000yi0  14920000000xi0  14940000000vi0  14960000000ti0  14980000000ri0  15000000000i0  15020000000i0  15030000000i0  15050000000}i0  15060000000|i0  15070000000{i0  15070000000{i0  15080000000zi0  15080000000zi0  15080000000zi0  15080000000z";
		    	  }else{
		    		   /*bruta = "ST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG"
		    				  + "\nST,GS,+00000040 KG";*/
		    		  bruta = "i0 14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14900000000zi0  14910000000yi0  14920000000xi0  14940000000vi0  14960000000ti0  14980000000ri0  15000000000i0  15020000000i0  15030000000i0  15050000000}i0  15060000000|i0  15070000000{i0  15070000000{i0  15080000000zi0  15080000000zi0  15080000000zi0  15080000000z";
		    	  }

		      List<BigDecimal> pesos = EncontradorPesos.getInstance().pesosEncontrados(bruta, balanca);
		      
                      System.out.println(pesos);
		      for(BigDecimal peso: pesos) {
		    	  //System.out.println(peso);
		    	  if(peso == new BigDecimal(-1)) {
		    		  caixa.setText(caixa.getText()+"\nEntrada Inválida\n");
		    	  }else {
		    	  caixa.setText(caixa.getText()+"\nPeso Recebido: "+ peso.toString()+" KG\n");
		    	  }
		      }
                          
		    	  //caixa.setText("Peso recebido:"+ bruta+"\n"+caixa.getText());
                          caixa.setText(caixa.getText()+"\nServidor publicado na porta "+Integer.toString(servidor.getLocalPort()));
                          caixa.setText(caixa.getText()+"\nPesos Recebidos pela porta "+comn);
		      }
		      
		      while(true) {
		        // o m�todo accept() bloqueia a execu��o at� que
		        // o servidor receba um pedido de conex�o
		        Socket cliente = servidor.accept();
		        BigDecimal pesoReal = null;
		        if(isAmbienteTeste) {
		        Random random = new Random();
				double sorteiaNumero = random.nextDouble();
				pesoReal =BigDecimal.valueOf(sorteiaNumero).multiply(BigDecimal.valueOf(1000.D));
				pesoReal= pesoReal.setScale(2, RoundingMode.FLOOR);
                                System.out.println("\n"+pesoReal);
		        }
		        
	            List<BigDecimal> pesos = EncontradorPesos.getInstance().pesosEncontrados(SerialComunications.getInstance().consutaSerial(comn,balanca), balanca);
	            
			      for(BigDecimal peso: pesos) {
			    	  System.out.println(peso);
			    	  caixa.setText("Peso recebido:"+ peso.toString()+" KG\n"+caixa.getText());
			      }
                  caixa.setText(caixa.getText()+"\nServidor publicado na porta "+Integer.toString(servidor.getLocalPort()));
                  caixa.setText(caixa.getText()+"\nPesos Recebidos pela porta "+comn);
		        
			 	caixa.setText("Cliente conectado: " + cliente.getInetAddress().getHostAddress()+"\n"+caixa.getText());
			 	//System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
		        
				System.out.println("antes");
		        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
		        saida.flush();
		        //System.out.println("depois");
		        if(isAmbienteTeste)
		        	 saida.writeObject(pesoReal.toString());
		        else
		        {
		        	//System.out.println("Ir� consultar"); 
		        saida.writeObject(pesos.get(0).toString());
		        }
		       
		       // caixa.setText("Peso real: "+pesoReal.toString()+"\n"+ caixa.getText());		       
		        
		        saida.close();
		        cliente.close();
                        //servidor.close();
		      }  
		    }   
		    catch(Exception e) {
		       System.out.println("Erro: " + e.getMessage());
		       new JOptionPane().showMessageDialog(new JFrame(),"Erro: " + e.getMessage(),"Erro",JOptionPane.WARNING_MESSAGE);
		    }
		    finally {
		    	
		    }  
		  }
}
