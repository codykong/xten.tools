package com.generaltest.adapter.service.impl;

import com.generaltest.adapter.service.FileLogApi;


public class FileLog implements FileLogApi {
	
	public void operateLog(String log){
		System.out.println("文件处理log:"+log);
	}

}
