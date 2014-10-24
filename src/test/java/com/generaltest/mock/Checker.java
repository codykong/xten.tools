package com.generaltest.mock;

import java.util.Calendar;

public class Checker {
	
	public Checker(Environmental anEnv){
		
		env=anEnv;
	}
	
	private Environmental env;
		
	public void reminder(){
		Calendar cal=Calendar.getInstance();
		cal.setTimeInMillis(env.getTime());
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour>=17){
			env.playWavFile("quit_whistle.wav");
		}
	}
	
}
