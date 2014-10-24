package com.generaltest;

import org.junit.Test;
import org.springframework.util.StringUtils;

import com.basetest.BaseTest;

public class CSVTest extends BaseTest {
	
	@Test
	public void testCSV(){
		
		String pks="aaa,sss,ddd,fff,ggg,hhh";
		String[] pkArray=StringUtils.commaDelimitedListToStringArray(pks);
		int pkLen=pkArray.length;
		if(null!=pkArray&&pkLen>0){
			for(int i=0;i<pkLen;i++){
				if(pkArray[0].equals("aaa")){
					System.out.println("yes");
				}
				System.out.println(pkArray[i]);
				System.out.println("+++");
			}
		}
	}

}
