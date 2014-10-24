package com.generaltest.singleton;

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
	
	private static AppConfig instance=new AppConfig();
	
	public static AppConfig getInstance(){
		return instance;
	}

	private String paramA;
	
	private String paramB;

	public String getParamA() {
		return paramA;
	}

	public String getParamB() {
		return paramB;
	}
	
	private AppConfig(){
		readConfig();
	}
	
	private void readConfig(){
		
		Properties p=new Properties();
		InputStream in=null;
		try{
			in=AppConfig.class.getResourceAsStream("common.properties");			
			p.load(in);
			this.paramA=p.getProperty("paramA");
			this.paramB=p.getProperty("paramB");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}finally{
			try{
				in.close();
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
	}


	
}
