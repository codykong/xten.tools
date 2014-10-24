package com.generaltest.mock;

public class MockSystemEnvironment implements Environmental {
	
	private long current_time;
	
	private boolean playedWav=false;
	
	public long getTime(){
		return current_time;
	}
	
	public void setTime(long aTime){
		current_time=aTime;
	}
	
	public void playWavFile(String filename){
		playedWav=true;
	}
	
	public boolean wavWasPlayed(){
		return playedWav;
	}
	


}
