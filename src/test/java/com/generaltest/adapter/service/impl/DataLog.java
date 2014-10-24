package com.generaltest.adapter.service.impl;

import com.generaltest.adapter.service.DataLogApi;

public class DataLog implements DataLogApi {
	
	public void dealLog(String log){
		System.out.println("数据库处理log:"+log);
	}

}
