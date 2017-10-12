package com.lzx.ssm.common.service;

import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.base.Base;

/**
 * 公共Service抽象类
 * @author lzx
 * **/
public abstract class BaseServiceImpl extends Base 
{
	protected volatile JSONObject resultJSON = new JSONObject();
	protected volatile JSONObject dataJSON = new JSONObject();
	
	protected void clearJSON()
	{
		this.resultJSON.clear();
		this.dataJSON.clear();
	}
}
