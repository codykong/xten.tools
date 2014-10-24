package com.xten.common.utils;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import java.io.*;
import java.util.Properties;

public class ExternalPropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	private File configDir;//配置文件路径
	private File[] propertiesFiles;//配置文件集合
	private File log4jFile;//log4j文件
	private String propDirectoryPath;
	
	public void loadProperties(Properties props) throws IOException {
		ClassPathResource resource=new ClassPathResource("/config");
		if(resource.exists())
		configDir=resource.getFile();
		propDirectoryPath=configDir.getAbsolutePath();
		propertiesFiles=configDir.listFiles(new PropertiesFilter());
		log4jFile=new ClassPathResource("/config/log4j.properties").getFile();
		//2、加载log4j配置文件，如果没有则不让程序启动
		if(!log4jFile.exists()){
          throw new IOException("log4j.properties can not be found");
		}
//		Properties log4j=new Properties();
//        log4j.load(new InputStreamReader(new FileInputStream(log4jFile)));
        PropertyConfigurator.configure(log4jFile.getAbsolutePath());//重载log4j
        
        logger.info("propDirectoryPath is "+propDirectoryPath);
		if (propertiesFiles != null && propertiesFiles.length > 0) {
			logger.info(propDirectoryPath+" has "+propertiesFiles.length+" properties: ");
		
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
			logger.error("can't find properties  in "+propDirectoryPath);		
		}
	}
	static class PropertiesFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			return name.endsWith(".properties");
		}
	}

}
