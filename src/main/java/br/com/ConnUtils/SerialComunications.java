/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConnUtils;

import java.io.IOException;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

/**
 *
 * @author felip
 */
public class SerialComunications {
    private static SerialComunications INSTANCE;
    
    private void SerialComunications(){
        
    }    
    
    public static SerialComunications getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SerialComunications();
        
        return INSTANCE;
    }
    
    public String consutaSerial() {
		
		 String msgDecode = null;
		 
		 if(true) {                     
		 SerialPort serialPort =null;
		 serialPort = new SerialPort("COM1");
                 
	        try {
				
	        	System.out.println("\n Abriu");
			  
			     System.out.println("\n Parametros");
			     
			     serialPort.openPort();//Open serial port
			     
			        
			        System.out.println("\n ReadBytes");
				     
			        serialPort.setParams(
			        		SerialPort.BAUDRATE_9600,
			        		SerialPort.DATABITS_8, 
			        		1, 0);//Set params.
			        
			        byte[] buffer = null;
			        
			   //     while (true) {

				//	try {
						buffer = serialPort.readBytes(40);
						serialPort.closePort();
				//	} catch (SerialPortTimeoutException e) {
						// TODO Auto-generated catch block
					//	e.printStackTrace();
				//	}//Read 10 bytes from serial port
			       
			      //  serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

			        //System.out.println("\n Variavel");
			        
						
			
						
						
			         msgDecode  = new String(buffer);
			       System.out.println(msgDecode);
			     //  caixa.setText(msgDecode+caixa);
			   //     }
			        
	        
			} catch (SerialPortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//Set params
		 }  
		return msgDecode;
	} 
    
    public int read(SerialPort serialPort) throws IOException {
	    while (true) {
	      try {
	        if (!serialPort.isOpened())
	          return -1;
	        return serialPort.readBytes(1, 100)[0];
	      } catch (final SerialPortTimeoutException e) {
	        // ignore and try again
	      } catch (final SerialPortException e) {
	        if (e.getMessage().contains("Port not opened"))
	          return -1;
	        throw new IOException(e);
	      }
	    }
	  };
    
    public void write(SerialPort serialPort,int b) throws IOException {
	  try {
	    serialPort.writeByte((byte) b);
	  } catch (final SerialPortException e) {
	    throw new IOException(e);
	  }
	  
	}
}
