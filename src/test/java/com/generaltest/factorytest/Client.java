package com.generaltest.factorytest;

import org.junit.Test;

import com.basetest.BaseTest;

public class Client extends BaseTest {
	
	@Test
	public void testClient(){
		Api api=Factory.createApi();
		api.operation("真的成功了呢！");
	}
}
