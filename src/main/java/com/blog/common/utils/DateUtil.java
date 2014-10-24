package com.blog.common.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author kongqingyu
 * @version 创建时间：2012-7-9 下午7:53:50
 * 类说明
 */
public class DateUtil {
	public static final String YYYYMMDD = "yyyyMMdd";
	
	public static final String YYYY_MM_DD ="yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";


	public static final String YYYYMM_CN = "yyyy年MM月";
	public static final String YYYYMMdd_CN= "yyyy年MM月dd日";
	public static final String YYYYMM = "yyyyMM";
	
	public static final String YYYYMMDDhhmmss = "yyyyMMddHHmmss";
	
	public static Date toDateForYYYYMMddhhmmss(String date){
		try{

			return  new SimpleDateFormat().parse(date);
		}catch(Exception e){
		    throw new RuntimeException("解析日期错误:" + date + "失败");
		}
	}


	public static Integer toYYYYMM_fromYYYY_MM_DD(String dateStr){
		try {
			if(StringUtils.isEmpty(dateStr)){
				return null;
			}
			return Integer.valueOf(new SimpleDateFormat(YYYYMM).format( new SimpleDateFormat(YYYY_MM_DD).parse(dateStr)));
		} catch (Exception e) {
		    throw new RuntimeException("解析日期错误:" + dateStr + "失败");
		}
	}
	public static String toYYYYMM_CN(int dateInt){
		try {
			return new SimpleDateFormat(YYYYMM_CN).format(new SimpleDateFormat(YYYYMM).parse(String.valueOf(dateInt)));
		} catch (Exception e) {
		    throw new RuntimeException("解析日期错误:" + dateInt + "失败");
		}
	}
	public static String toYYYYMMDDD_CN(Date date){
		try {
			return  new SimpleDateFormat(YYYYMMdd_CN).format(date);
		} catch (Exception e) {
		    throw new RuntimeException("解析日期错误:" + date + "失败");
		}
	}
	public static String toStringYYYYMMDD_HH_mm_ss(Date date){
		try {
			return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).format(date);
		} catch (Exception e) {
		    throw new RuntimeException("解析日期错误:" + date + "失败");
		}
	}
	public static Date fromYYYYMM_HH_mm_ss(String dateString){
        try {
            return new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS).parse(dateString);
        } catch (ParseException e) {
           throw new RuntimeException("解析日期错误:" + dateString + "失败");
        }
    }
	public static Date fromYYYYMMDD_Int(Integer dateInt){
		try {
			return new SimpleDateFormat(YYYYMMDD).parse(dateInt.toString());
		} catch (ParseException e) {
		    throw new RuntimeException("解析日期错误:" + dateInt + "失败");
		}
	}
	public static Date fromYYYYMMDD_String(String dateString){
		try {
			return new SimpleDateFormat(YYYYMMDD).parse(dateString);
		} catch (ParseException e) {
		    throw new RuntimeException("解析日期错误:" + dateString + "失败");
		}
	}
	public static Date fromYYYY_MM_DD(String dateString){
		try {
			return new SimpleDateFormat(YYYYMMDD).parse(dateString);
		} catch (ParseException e) {
		    throw new RuntimeException("解析日期错误:" + dateString + "失败");
		}
	}
	public static int toYYYYMMDDfromDate(Date date){
	    try {
	        return Integer.valueOf(new SimpleDateFormat(YYYYMMDD).format(date));
	    } catch (Exception e) {
	        throw new RuntimeException("解析日期错误:" + date + "失败");
        }
	}

	public static String toYYYY_MM_DD_String(Date date){
	    try {
	        return new SimpleDateFormat(YYYY_MM_DD).format(date);
	    } catch (Exception e) {
	        throw new RuntimeException("解析日期错误:" + date + "失败");
        }
	}

	public static String toInt_YYYYMMDDhhmmss(Date date){
		try {
			if(date == null){
				return null;
			}
			return new SimpleDateFormat(YYYYMMDDhhmmss).format(date);
		} catch (Exception e) {
		    throw new RuntimeException("解析日期错误:" + date + "失败");
		}
	}

}
