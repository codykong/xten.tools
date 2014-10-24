package com.generaltest.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

import com.basetest.BaseTest;
import com.generaltest.classload.Car;

public class FlectionTest extends BaseTest {
	
	@Test
	public void testFlection() throws Throwable{
		
		Car car=initByDefaulConst();
		car.introduce();
	}
	
	public static Car initByDefaulConst() throws Throwable{
		
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		Class<?> clazz=loader.loadClass("com.generaltest.bean.Car");
		
		Constructor<?> cons=clazz.getDeclaredConstructor((Class[])null);
		Car car=(Car)cons.newInstance();
		
		Method setBrand=clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "BMW");
		Method setColor=clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "black");
		return car;
	}

}
