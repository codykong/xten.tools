package com.generaltest;

import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class CionTurnTest {
	
	private int[] coin={0,0,0,0,0,0,0};
	
	private Boolean res=true;
	
	
	public static void main(String[] args){
		
		String num="";
		
		/*while(res){*/
			Scanner in=new Scanner(System.in);
			System.out.println("Enter class name(e.g. java.util.Date):");
			num=in.next();
			
			String[] nums=StringUtils.split(num, ",");
			
			System.out.println(nums.toString());
		/*}*/
		
		
	}

}
