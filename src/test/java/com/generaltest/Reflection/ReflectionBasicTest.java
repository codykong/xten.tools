package com.generaltest.Reflection;

import org.junit.Test;

import com.basetest.BaseTest;

public class ReflectionBasicTest extends BaseTest {

	@Test
	public void testReflectionBasic() throws ClassNotFoundException{
		
		String oname="com.generaltest.bean.NewTestObject";
		Class cl=Class.forName(oname);
		String name=cl.getName();
		System.out.println(name);
		
	}
}
