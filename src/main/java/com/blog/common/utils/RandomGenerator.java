package com.blog.common.utils;

import java.util.Random;

public class RandomGenerator {
	
	private static String range="01234567890abcdefghijklmnopqrstuvwxyz";
	
	public static synchronized String getRandomCaption(){
		
		Random random=new Random();
		
		StringBuffer result=new StringBuffer();
		
		for(int i=0;i<4;i++){
			result.append(range.charAt(random.nextInt(range.length())));
		}
		
		return result.toString();
	}
	
	

}
