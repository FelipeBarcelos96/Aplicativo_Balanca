/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.scriptUtils;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author felip
 */
public class ManipuladorDeJavaScripts {
	
	private static ManipuladorDeJavaScripts INSTANCE;
    
        ArrayList<String> scripts =  new ArrayList<String>();
	
	public String ehNumerico = "function isNumeric(str) {\r\n" + 
			"var er = /^[0-9]+$/;\r\n" + 
			"return (er.test(str));\r\n" + 
			"}";
	
	public String removeEspacosVaziosDeArray = "function removeEspacosVaziosDeArray(str) {"+
			 "var filtered = str.filter(function (el) {\r\n" + 
			 "  return el != '';\r\n" + 
			 "});\r\n" + 
			 "return filtered;"
			+"}";
    
    private ManipuladorDeJavaScripts() {
        scripts.add(ehNumerico);
        scripts.add(removeEspacosVaziosDeArray);
    }
    
    public static ManipuladorDeJavaScripts getInstance() {
    	if(null != INSTANCE) {
    		return INSTANCE;
    	}else {
    		INSTANCE = new ManipuladorDeJavaScripts();
    		return INSTANCE;
    	}
    }

    public String getScripts() {
        StringBuilder sb = new StringBuilder();
        for(String script : scripts) {
        	sb.append(script);
        }
        return sb.toString();
    }
    
    public void novoScript(String script) {
    	this.scripts.add(script);
    }
    
    public void removeScript(String script) {
    	this.scripts.remove(script);
    }
    
    public int localizaScript(String script) {
    	return this.scripts.indexOf(script);
    }
    
    public void substituiScript(String script, int i) {
    	this.scripts.remove(i);
    	this.scripts.add(i, script);
    }
    
    public String executaScript(String script, String bruta) {
    	String scripts = script + this.getScripts();
    	ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        try {
            engine.put("stringBruta", bruta);
           // engine.put("bParam", 10);
            engine.eval(scripts);
            engine.eval("print('Resultado: '+ processador(stringBruta) )");
            engine.eval("var s = processador(stringBruta)");

            // create the engine and have it load your javascript
            Bindings bind = engine.getBindings(ScriptContext.ENGINE_SCOPE);
            
            System.out.println( engine.get("s").toString());                  

        } catch (ScriptException e) {
            e.printStackTrace();
        }          
        return engine.get("s").toString();
    }
}
