package br.com.cofrinho.utils;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoadDefaultMessage {
	private ApplicationContext context;

	public String getMessage(String key) {		
	context = new ClassPathXmlApplicationContext("messageContext.xml");
	Locale locale = new Locale.Builder().setLanguage("pt").setRegion("BR").build();
	return context.getMessage(key,new Object[] {}, locale);		
	}
}
