package br.com.sankhya.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class ManipuladorDePropriedades {
	public static String dir = "dados.properties";

	public static Properties getProp() throws IOException {
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(dir);
				//"./properties/dados.properties");
		props.load(file);
		return props;		
	}
	
	public static void saveProps(Properties props) throws IOException{
		FileOutputStream file = new FileOutputStream(dir);
		props.store(file, null);
	}
	
	public static int getBaudrate() throws NumberFormatException, IOException {
		int baudrate = Integer.parseInt(ManipuladorDePropriedades.getProp().getProperty("baudrate"));
		if(baudrate <= 110) {
			return 110;
		}else if(baudrate > 110 && baudrate <= 300) {
			return 300;
		}else if(baudrate > 300 && baudrate <= 600) {
			return 600;
		}else if(baudrate > 600 && baudrate <= 1200) {
			return 1200;
		}else if(baudrate > 1200 && baudrate <= 2400) {
			return 2400;
		}else if(baudrate > 2400 && baudrate <= 4800) {
			return 4800;
		}else if(baudrate > 4800 && baudrate <= 9600) {
			return 9600;
		}else if(baudrate > 9600 && baudrate <= 14400) {
			return 14400;
		}else if(baudrate > 14400 && baudrate <= 19200) {
			return 19200;
		}else if(baudrate > 19200 && baudrate <= 38400) {
			return 38400;
		}else if(baudrate > 38400 && baudrate <= 57600) {
			return 57600;
		}else if(baudrate > 57600 && baudrate <= 115200) {
			return 115200;
		}else if(baudrate > 115200 && baudrate <= 128000) {
			return 128000;
		}else if(baudrate > 128000 && baudrate <= 256000) {
			return 256000;
		}else{
			return 256000;
		}
	}
	
	public static int getDataBits() throws NumberFormatException, IOException {
		int databits = Integer.parseInt(ManipuladorDePropriedades.getProp().getProperty("databits"));
		if(databits <= 5) {
			return 5;
		}else if(databits == 6) {
			return 6;			
		}else if(databits == 7) {
			return 7;
		}else {
			return 8;
		}
	}

}
