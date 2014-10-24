package com.generaltest.singleton;

import org.junit.Test;

import com.basetest.BaseTest;

public class AppConfigTest extends BaseTest {
	
	@Test
	public void testAppConfig(){
		
		ThreadSingleton app=ThreadSingleton.getInstance();
		AppConfig appConfig=AppConfig.getInstance();
		String paramA=appConfig.getParamA();
		String paramB=appConfig.getParamB();
		System.out.println("ParamA="+paramA+",ParamB="+paramB);

		String paramC=app.getParamA();
		String paramD=app.getParamB();
		System.out.println("ParamC="+paramC+",ParamD="+paramD);
	}

}
