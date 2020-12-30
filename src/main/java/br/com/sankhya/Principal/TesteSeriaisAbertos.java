/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.Principal;

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
    public static void main(String[] args) throws SerialPortException {
         SerialPort serialPort = new SerialPort("COM2");
         System.out.println(serialPort.getPortName());
         
         try {
         	if(serialPort.openPort()) {
         		System.out.println(serialPort.getPortName()+" está conectada");
         	}
         }catch(Exception e) {
         	System.out.println(serialPort.getPortName()+" está desconectada");
         }
         
         /*
         if(serialPort.isOpened())
                System.out.println(serialPort.getPortName()+" está conectada");
         System.out.println("/n"+serialPort.readString());  
         */
         
         /*
          for(int i=0; i<10; i++){
            serialPort = new SerialPort("COM"+Integer.toString(i+1));
            
            try {
            	if(serialPort.openPort()) {
            		System.out.println("COM"+Integer.toString(i+1)+" está conectada");
            	}
            }catch(Exception e) {
            	System.out.println("COM"+Integer.toString(i+1)+" está desconectada");
            }
            
          */  
           
            
            /*
            if(serialPort.isOpened()){
             
                System.out.println("COM"+Integer.toString(i+1)+" está conectada");
            }else{
                System.out.println("COM"+Integer.toString(i+1)+" está desconectada");
            }
            */
            
        }
   // }  
}
    

