package com.generaltest.iotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import com.basetest.BaseTest;

public class FileFoundTest extends BaseTest {
	
	private static SimpleDateFormat formate = new SimpleDateFormat("yyyyMMdd");
	
	@Test
	public void testFileFound() throws FileNotFoundException{
		String filename="Success.txt";
		String fileLoc="D:";
		Date yesDate=new Date();
		yesDate=DateUtils.addDays(yesDate, -1);
		String fileDate=String.valueOf(formate.format(yesDate));
		File fileList=new File(fileLoc+File.separator+fileDate+File.separator);
		if(null!=fileList&&null!=fileList.list()){
			for(String filesname:fileList.list()){
				if(filename.equalsIgnoreCase(filesname)){
					System.out.println("success");

				}
			}
		}else{
			System.out.println("Failed");
		}
	}
}
