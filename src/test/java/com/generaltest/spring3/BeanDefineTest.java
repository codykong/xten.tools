package com.generaltest.spring3;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.basetest.BaseTest;
import com.generaltest.bean.Car;

public class BeanDefineTest extends BaseTest {

	@Autowired
	private Car car;
	
	@Test
	public void testStructorInject(){
		
		System.out.println(car.getColor());
		System.out.println(car.getWeigth());
	}
}
