package br.com.cofrinho.utils;

import java.io.IOException;
import java.util.Properties;

public class Util {				  
	
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		props.load(Util.class.getResourceAsStream("/messages.properties"));
		return props;
	}
	
	public static String getMessage(String key) throws IOException {		
		return getProp().getProperty(key);
	}	
	
}
