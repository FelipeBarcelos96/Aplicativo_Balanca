package br.com.sankhya.Principal;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.sankhya.scriptUtils.ManipuladorDeJavaScripts;
import br.com.sankhya.utils.ManipuladorDePropriedades;
import br.com.sankhya.utils.ManipuladorArquivo;

public class Testes {
	
    public void teste3() throws IOException {    	
    	String baudrate; 
    	String databits; 
		String comn; 
		String dirFunc;
		System.out.println("************Teste de leitura do arquivo de propriedades************");	
		

		Properties prop = ManipuladorDePropriedades.getProp();
		

		baudrate = prop.getProperty("baudrate");
		databits = prop.getProperty("databits");
		comn = prop.getProperty("comn");
		dirFunc = prop.getProperty("funcao");
		String leitura = ManipuladorArquivo.getInstance().leitor(dirFunc);
		
		prop.setProperty("comn", "2");
		ManipuladorDePropriedades.saveProps(prop);
		comn = ManipuladorDePropriedades.getProp().getProperty("comn");

		System.out.println("baudrate = " + baudrate);		
		System.out.println("databits = " + databits);
		System.out.println("comn = " + comn);
		System.out.println("funcao = " + dirFunc);
		System.out.println( leitura );
		
		String bruta = "i0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14880000000si0  14900000000zi0  14910000000yi0  14920000000xi0  14940000000vi0  14960000000ti0  14980000000ri0  15000000000i0  15020000000i0  15030000000i0  15050000000}i0  15060000000|i0  15070000000{i0  15070000000{i0  15080000000zi0  15080000000zi0  15080000000zi0  15080000000z";
		String resultado = ManipuladorDeJavaScripts.getInstance().executaScript(leitura, bruta);
		System.out.println( resultado );
		
    }
}
