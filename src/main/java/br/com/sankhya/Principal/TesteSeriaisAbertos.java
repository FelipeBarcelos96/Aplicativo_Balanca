/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jssc.SerialPort;
import jssc.SerialPortException;

/**
 *
 * @author felip
 */
public class TesteSeriaisAbertos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SerialPortException, MalformedURLException {
         /*
          * SerialPort serialPort = new SerialPort("COM2");
         System.out.println(serialPort.getPortName());
         
         try {
         	if(serialPort.openPort()) {
         		System.out.println(serialPort.getPortName()+" está conectada");
         	}
         }catch(Exception e) {
         	System.out.println(serialPort.getPortName()+" está desconectada");
         }*/
        URL url;
        StringBuilder sb = new StringBuilder();
		try {
			url = new URL("https://github.com/FelipeBarcelos96/Login-with-preloader/find/main");
			HttpURLConnection conection = (HttpURLConnection) url.openConnection();
			conection.setRequestMethod("GET");
			//String resposta = conection.getResponseMessage();
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream())
					);
			StringBuffer resposta = new StringBuffer();
			
			
			String linha = "";
			while (true) {
				if (null != linha) {				
					sb.append(linha).append("\n");

				} else
					break;
				linha = in.readLine();
			}
			in.close();
			System.out.println( sb.toString() );
			//System.out.println(resposta);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
         
            
        
      

    }
}
    

