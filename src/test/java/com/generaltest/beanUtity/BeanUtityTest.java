package com.generaltest.beanUtity;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.basetest.BaseTest;
import com.generaltest.bean.NewTestObject;
import com.generaltest.bean.OldTestObject;

public class BeanUtityTest extends BaseTest {
	
	@Test
	public void testCopyProperties(){
		
		NewTestObject newO=new NewTestObject();
		newO.setAges("2");
		newO.setName(11);
		newO.setPks(1);
		
		OldTestObject oldO=new OldTestObject(0, "");
		try{
		BeanUtils.copyProperties(newO, oldO);
		
		System.out.println(oldO.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
