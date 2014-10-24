package com.generaltest.singleton;

import java.io.InputStream;
import java.util.Properties;

public class ThreadSingleton {
	
	private static class SingletonHolder{
		
		private static ThreadSingleton instance=new ThreadSingleton();
	}
	
	private ThreadSingleton(){
		readConfig();
	}
	
	public static ThreadSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
	private String paramA;
	
	private String paramB;

	public String getParamA() {
		return paramA;
	}

	public String getParamB() {
		return paramB;
	}
	

	private void readConfig(){
		
		Properties p=new Properties();
		InputStream in=null;
		try{
			in=AppConfig.class.getResourceAsStream("common.properties");			
			p.load(in);
			this.paramA=p.getProperty("paramC");
			this.paramB=p.getProperty("paramD");
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
