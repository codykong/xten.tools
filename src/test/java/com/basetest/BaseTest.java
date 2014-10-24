package com.basetest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/*-config.xml"})
public class BaseTest {
	
	@Before
	public void preTest(){
		System.out.println("----------------------------");
	}
	
	@After
	public void endTest(){
		System.out.println("----------------------------");
	}
	
	@Test
	public void testTest(){
        System.out.println("#----------------------------");
	}
}

