package com.generaltest.array;



import java.util.Arrays;

import com.generaltest.bean.OldTestObject;

public class ArraysTest {
	
	
	public static void main(String[] args){
		
		OldTestObject[] listOld=new OldTestObject[3];
		
		listOld[0]=new OldTestObject(2,"aaa");
		listOld[1]=new OldTestObject(1,"sss");
		listOld[2]=new OldTestObject(3,"ddd");
		Arrays.sort(listOld);
		
		for(OldTestObject o:listOld){
			System.out.println("pk:"+o.getPk()+",name:"+o.getName());
		}

	}
	
	

}
