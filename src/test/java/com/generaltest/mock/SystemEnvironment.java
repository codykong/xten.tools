package com.generaltest.mock;

public class SystemEnvironment implements Environmental {
	
	public long getTime(){
		return System.currentTimeMillis();
	}
	
	public void playWavFile(String filename){
		System.out.println(filename);
	}
	

}
