/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.Principal;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import br.com.sankhya.utils.ManipuladorArquivo;

/**
 *
 * @author felip
 */
public class TesteProcessamento {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    	new Testes().teste();
    }    
    
}
