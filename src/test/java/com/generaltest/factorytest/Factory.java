package com.generaltest.factorytest;

import java.io.InputStream;
import java.util.Properties;

public class Factory {
	
	public static Api createApi(){
		
		Properties p=new Properties();
		InputStream in=null;
		
		try{
			in=Factory.class.getResourceAsStream("factory.properties");
			p.load(in);
		}catch (Exception e) {
			System.out.println("装载工厂配置文件出错了，具体的堆栈信息如下：");
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Api api=null;
		try{
			api=(Api)Class.forName(p.getProperty("ImplClass")).newInstance();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return api;
	}

}
