package com.lzx.ssm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 * 常用日期格式转化工具类
 * @author lzx
 * */
@Component("dateFormatUtil")
public class DateFormatUtil
{
	/**
	 * 进行日期时间格式转换  yyyy-MM-dd HH:mm:ss
	 * @param nowDate
	 * @return String
	 * */
	public static String formatDateTime(Date nowDate)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(ConstantFinalUtil.BUNDLE.getString("format.datetime"));
		return sdf.format(nowDate);
	}
	
	/**
	 * 进行日期格式转换  yyyy-MM-dd
	 * @param nowDate
	 * @return String
	 * */
	public static String formatDate(Date nowDate)
	{
		SimpleDateFormat sdf=new SimpleDateFormat(ConstantFinalUtil.BUNDLE.getString("format.date"));
		return sdf.format(nowDate);
	}
	
	/**
	 * 字符串转日期时间
	 * @param now
	 * @return Date
	 * */
	public static Date parseDateTime(String now)
	{
		try
		{
			SimpleDateFormat sdf=new SimpleDateFormat(ConstantFinalUtil.BUNDLE.getString("format.datetime"));
			return sdf.parse(now);
		} catch (ParseException e)
		{
		}
		return null;
	}
	
	/**
	 * 字符串转化日期
	 * @param String now
	 * */
	public static Date parseDate(String now)
	{
		try
		{
			SimpleDateFormat sdf=new SimpleDateFormat(ConstantFinalUtil.BUNDLE.getString("format.date"));
			return sdf.parse(now);
		} catch (ParseException e)
		{
		}
		return null;
	}
}
