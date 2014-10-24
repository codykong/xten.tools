package com.blog.common.base.spring;

import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-5
 * Time: 下午3:31
 * 载入配置文件（未启用）
 */
public class Config {

    private static Properties properties;

    public static void initConfig(Properties pro){
        Properties newPro = new Properties();
        for(Map.Entry en:pro.entrySet()){
            newPro.put(en.getKey(),en.getValue());
        }
        Config.properties = newPro;
    }
    public static String getKey(String key){
        return properties.getProperty(key);
    }
    public static String getKey(String key,String defaultValue){
        return properties.getProperty(key,defaultValue);
    }
}
