package com.generaltest.adapter.service;


public class NewAdapter implements DataLogApi,FileLogApi {

	private DataLogApi dataLogApi;
	
	private FileLogApi fileLogApi;
	
	public NewAdapter(DataLogApi dataLogApi,FileLogApi fileLogApi){
		this.dataLogApi=dataLogApi;
		this.fileLogApi=fileLogApi;
	}
	
	@Override
	public void operateLog(String log) {
		
		dataLogApi.dealLog(log);
		fileLogApi.operateLog(log);
		
	}
	
	@Override
	public void dealLog(String log){
		
		fileLogApi.operateLog(log);
		dataLogApi.dealLog(log);
		
	}

}
