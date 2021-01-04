/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.ConnUtils;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import jssc.SerialPort;

/**
 *
 * @author felip
 */
public class IdentificadorDeSeriais {    
    
    private IdentificadorDeSeriais() {
    }
    
    public static IdentificadorDeSeriais getInstance() {
        return IdentificadorDeSeriaisHolder.INSTANCE;
    }
    
    private static class IdentificadorDeSeriaisHolder {

        private static final IdentificadorDeSeriais INSTANCE = new IdentificadorDeSeriais();
    }
    
    public ArrayList<String> listarSeriais(Boolean isAmbienteTeste){
        ArrayList<String> seriais = new ArrayList<String>();
        
        if(isAmbienteTeste){
        seriais.add("COM1");
        seriais.add("COM2");
        seriais.add("COM3");
        seriais.add("COM4");
        seriais.add("COM5");
        }else{
            
        SerialPort serialPort;
        String porta;
        
          for(int i=0; i<10; i++){
            
            porta = "COM"+Integer.toString(i+1);
            //new JOptionPane().showMessageDialog(new JFrame(),"DEBUG!","Aviso",JOptionPane.WARNING_MESSAGE);
            serialPort = new SerialPort(porta);
            
            /*
            try{
                serialPort.openPort();
                seriais.add(porta);
            }catch(Exception e){
                
            }
            */            
            
            if(!serialPort.isOpened()){
                seriais.add("COM"+Integer.toString(i+1));
            }
            
          }
        }
        
        if(seriais.isEmpty())
            new JOptionPane().showMessageDialog(new JFrame(),"Sem Balança Detectada!","Aviso",JOptionPane.WARNING_MESSAGE);
        
        return seriais;
    }
}
