/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConnUtils;

import java.util.ArrayList;
import jssc.SerialPort;

/**
 *
 * @author felip
 */
public class IdentificadorDeSeriais {
    ArrayList<String> seriais = new ArrayList<String>();
    
    private IdentificadorDeSeriais() {
    }
    
    public static IdentificadorDeSeriais getInstance() {
        return IdentificadorDeSeriaisHolder.INSTANCE;
    }
    
    private static class IdentificadorDeSeriaisHolder {

        private static final IdentificadorDeSeriais INSTANCE = new IdentificadorDeSeriais();
    }
    
    public ArrayList<String> listarSeriais(){
        seriais = null;
        SerialPort serialPort =null;
        for(int i=0; i<20; i++){
            serialPort = new SerialPort("COM"+Integer.toString(i+1));
            if(serialPort.isOpened()){
                seriais.add("COM"+Integer.toString(i+1));
            }
        }
        return seriais;
    }
}
