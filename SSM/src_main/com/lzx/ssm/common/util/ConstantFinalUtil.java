package com.lzx.ssm.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 静态常量工具类
 * @author lzx
 * */
public class ConstantFinalUtil 
{  
	public static final Logger loggerMsg = LogManager.getLogger(ConstantFinalUtil.class);
	// 获取properties属性文件信息,只需获取属性文件名称即可
	public static ResourceBundle BUNDLE = ResourceBundle.getBundle("common");
	// 全部随机字符的字母表
	public static String ALLSTR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	// 总计操作地址数
	public static int count = 1;
	//存放参数使用的map
	public static Map<String,Object> paramMap=new HashMap<String,Object>();
	//公共线程池
	public static ExecutorService executorService = Executors.newCachedThreadPool();
	
	/**
	 * 用于获取Map对象
	 * */
	public static Map<String,Object> getParamMap()
	{
		paramMap.clear();
		return paramMap;
	}
	
	/**
	 * 生成uuid
	 * */
	public static String getRandomUUID()
	{
		UUID uuid=UUID.randomUUID();
		String uuidStr=uuid.toString().replaceAll("-", "");
		return uuidStr;
	}
	
}
