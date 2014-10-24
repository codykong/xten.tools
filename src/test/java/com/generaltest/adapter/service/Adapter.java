package com.generaltest.adapter.service;

import com.generaltest.adapter.service.impl.FileLog;

public class Adapter  implements Target{
	
	private FileLog  fileLog;  
	
	public Adapter(FileLog fileLog){
		this.fileLog=fileLog;
	}
	
	public void operateLog(String log){
		System.out.println("my new operate is:"+log);
		fileLog.operateLog(log);
	}

}
