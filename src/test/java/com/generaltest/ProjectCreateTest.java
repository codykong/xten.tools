package com.generaltest;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.basetest.BaseTest;


public class ProjectCreateTest extends BaseTest {
	
	@Test
	public void testProjectCreate(){
		
		Map<String,String>  map=new TreeMap<String,String>(new Comparator<String>(){
            public int compare(String o1, String o2) {  
              
                return o2.compareTo(o1);  
            }     
        });
		
		Map<String, String> map1=new TreeMap<String, String>(map);
		
		HashMap<String, String> hashMap=new HashMap<String, String>();
		
		map.put("aaa", "aaaa");
		map.put("sss", "ssss");
		map.put("bbb", "bbbb");
		
		map1.put("111", "1111");
		map1.put("222", "2222");
		map1.put("555", "5555");
		map1.put("333", "3333");
		
		map.putAll(map1);
		
		
	
		
		System.out.println(map);
		System.out.println(map1);
		System.out.println(hashMap.keySet());
	}
}
