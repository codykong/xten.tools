package com.generaltest.nettest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

import com.basetest.BaseTest;

public class InetTest extends BaseTest{
	
	@Test
	public void testInet(){
		InetAddress addr=null;
		try {
			addr = InetAddress.getLocalHost();
		
		String ip=addr.getHostAddress().toString();//获得本机IP
		System.out.println(ip);
		}catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	

}
