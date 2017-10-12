package com.lzx.ssm.common.base;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.lzx.ssm.common.util.ConstantFinalUtil;
import com.lzx.ssm.common.util.DateFormatUtil;
import com.lzx.ssm.common.util.PageInfoUtil;

/**
 * 基础参数的父类
 * @author lzx
 * */
public abstract class Base
{
	//日志对象
	protected Logger loggerMsg = LogManager.getLogger(ConstantFinalUtil.class);
	//分页工具
	protected PageInfoUtil pageInfoUtil=new PageInfoUtil();
	//日期格式转换工具
	protected DateFormatUtil dateFormatUtil=new DateFormatUtil();
	//存放参数使用的map
	private Map<String,Object> paramMap=new HashMap<String,Object>();
	/**
	 * 用于获取Map对象
	 * */
	protected Map<String,Object> getParamMap()
	{
		paramMap.clear();
		return paramMap;
	}
	/**
	 * 生成uuid
	 * */
	protected String getRandomUUID()
	{
		UUID uuid=UUID.randomUUID();
		String uuidStr=uuid.toString().replaceAll("-", "");
		return uuidStr;
	}
}
