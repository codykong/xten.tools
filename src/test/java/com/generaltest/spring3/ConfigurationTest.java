package com.generaltest.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationTest {
	
	public static void main(String[] args){
		
		ApplicationContext ctc=new AnnotationConfigApplicationContext("AppConf.class");
		
		LoginTest test=ctc.getBean(LoginTest.class);
		
		test.printHello();
	}

}
