package com.blog.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-10-17
 * Time: 上午11:37
 * To change this template use File | Settings | File Templates.
 */
public class ParamUtil {

    public  static String  defaultString (String param, String defaults){
        if(param == null || "".equals(param)) return defaults;
        return param;
    }

    public static int parseInt(String para, int defaults){
        try{
            return Integer.valueOf(para);
        }catch(Exception e){
            return defaults;
        }
    }

    public static  Date parseDate(String param,String patten, Date defaults){
        if(param == null || "".equals(param)) return defaults;
        DateFormat  format = new SimpleDateFormat(patten);
        try {
            return format.parse(param);
        } catch (ParseException e) {
            e.printStackTrace();
            return defaults;
        }
    }

    public static String subString(String param,int begin,int end ){
        if(null==param){
            return "";
        }else if(param.length()<(end-begin)){
            return param;
        }else{
            return param.substring(begin,end);
        }
    }


}
