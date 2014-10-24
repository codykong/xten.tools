package com.blog.common.base.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import com.blog.common.data.Constants;

/**
 * 配置属性文件
 * @author kongqingyu
 * @time 2013-3-4 下午5:41:11
 */

public class ExternalPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	private File configDir;		//配置文件路径
	private File[] propertiesFiles;		//配置文件集合
	private File log4jFile;		//log4j文件
	private String configPath;	//属性文件位置
	
	public void loadProperties(Properties props) throws IOException {
		//1、先从从外部文件夹下加载config；
		if("".equals(configPath)||configPath==null){
			configPath=Constants.DEFAULT_CONFIG_PATH;
		}
     	configDir = new File(configPath);
		if(!configDir.exists()){
			configDir.mkdirs();
		}
		propertiesFiles = configDir.listFiles(new PropertiesFilter());
	    log4jFile=new File(configPath+"/log4j.properties");
	    
	    
		//如果外部 config 里Properties 为空，则从class/config 下加载。
		if(propertiesFiles==null||propertiesFiles.length==0){
			ClassPathResource resource=new ClassPathResource("/config");
			if(resource.exists())
			configDir=resource.getFile();
			configPath=configDir.getAbsolutePath();
			propertiesFiles=configDir.listFiles(new PropertiesFilter());
			log4jFile=new ClassPathResource("/config/log4j.properties").getFile();
		}
		
		
		//2、加载log4j配置文件，如果没有则不让程序启动
			if(!log4jFile.exists()){
              throw new IOException("log4j.properties can not be found");
			}
			Properties log4j=new Properties();
            log4j.load(new InputStreamReader(new FileInputStream(log4jFile)));
            PropertyConfigurator.configure(log4j);//重载log4j
            
            logger.info("propDirectoryPath is "+configPath);
				if (propertiesFiles != null && propertiesFiles.length > 0) {
					logger.info(configPath+" has "+propertiesFiles.length+" properties: ");
				
					for (int i=0;i<propertiesFiles.length;i++) {
						File file=propertiesFiles[i];
						logger.info("file"+i+" is "+file.getName());
						PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
						InputStream is = null;
						try {
							is = new FileInputStream(file);
							
							propertiesPersister.load(props, is);
                            
						} finally {
							if (is != null)
								is.close();
						}
					}
					logger.info("properties has load ");	
				}else{
					logger.error("can't find properties  in "+configPath);		
				}
				

	}
	static class PropertiesFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return name.endsWith(".properties");
		}
	}
	
	
	public void setConfigPath(String configPath) {
		this.configPath = configPath;
	}
	

}
