package com.generaltest.adapter;

import org.junit.Test;

import com.basetest.BaseTest;
import com.generaltest.adapter.service.DataLogApi;
import com.generaltest.adapter.service.FileLogApi;
import com.generaltest.adapter.service.NewAdapter;
import com.generaltest.adapter.service.impl.DataLog;
import com.generaltest.adapter.service.impl.FileLog;

public class Client extends BaseTest {

	private FileLogApi fLog=new FileLog();
	private DataLogApi dLog=new DataLog();
	
	private FileLogApi fLog2=new NewAdapter(dLog, fLog);
	//private DataLogApi dLog2=new NewAdapter(dLog, fLog);
	
	@Test
	public void operateLog(){
		
		fLog2.operateLog("log日志");
		
	}
}
