package com.generaltest.mock;

import java.util.Calendar;

import org.junit.Test;

import com.basetest.BaseTest;

public class TestChecker extends BaseTest {
	
	@Test
	public void testQuittingTime(){
		
		MockSystemEnvironment env=new MockSystemEnvironment();
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, 2012);
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 16);
		cal.set(Calendar.MINUTE,55);
		long t1=cal.getTimeInMillis();
		env.setTime(t1);
		Checker checker=new Checker(env);
		
		checker.reminder();
		
		System.out.println(env.wavWasPlayed());
		
		t1+=(5*60*1000);
		env.setTime(t1);
		
		checker.reminder();
		
		System.out.println(env.wavWasPlayed());
		
		
		
		
	}

}
