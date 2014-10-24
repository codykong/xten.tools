package com.common;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.basetest.BaseTest;
import com.blog.common.utils.IDGeneratorUtil;
/**
 * 自增主键测试用例
 * @author kongqingyu
 * @Time 2013-5-20 下午4:19:53
 */
public class IDGeneratorTestClient extends BaseTest {

	@Autowired
	private IDGeneratorUtil idGeneratorUtil;
	
	@Test
	public void testIDFenerator(){
		
		long activityId = idGeneratorUtil.generateID("user");
		System.out.println(activityId);
	}
}
