/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.ConnUtils;

import java.util.ArrayList;
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
        }else{
        SerialPort serialPort;
          for(int i=0; i<20; i++){
            serialPort = new SerialPort("COM"+Integer.toString(i+1));
            if(serialPort.isOpened()){
                seriais.add("COM"+Integer.toString(i+1));
            }
          }
        }  
        return seriais;
    }
}
