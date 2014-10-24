package com.blog.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PicUploadController {

	@RequestMapping(value="/ch/upload",method=RequestMethod.POST)
	public String uploadPopPrivilige(@RequestParam("file") MultipartFile file, Model model){
		//取得文件后缀名
		try{
		String fileName = file.getOriginalFilename();
		int lastIndexOfDot = fileName.lastIndexOf('.');		 
        int fileNameLength = fileName.length();
		String type = fileName.substring(lastIndexOfDot+1, fileNameLength);
		}catch (Exception e) {

		}
		
		return "passport/regist";
	}
}
