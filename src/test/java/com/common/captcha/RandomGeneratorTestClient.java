package com.common.captcha;

import org.junit.Test;

import com.basetest.BaseTest;
import com.blog.common.utils.RandomGenerator;

public class RandomGeneratorTestClient extends BaseTest {
	
	@Test
	public void testGetRandomCaptcha(){
			
		System.out.println(RandomGenerator.getRandomCaption());
	}

}
