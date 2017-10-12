 package com.lzx.ssm.common.util;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.queue.reciver.MsgSaveAction;
/**
 * 数据分发与执行的线程
 * @author lzx
 * */
@Component("threadUtil")
@Scope("prototype")
public class ThreadUtil implements Runnable
{
	@Resource
	private MsgSaveAction msgSaveAction;
	private String queueName;
	private JSONObject jsonData;
	private String jmsType;
	
	public void run()
	{
		synchronized (this)
		{
			if(queueName.equalsIgnoreCase(ConstantFinalUtil.BUNDLE.getString("ssm.queue.user")))
			{
				if(jmsType.equalsIgnoreCase(ConstantFinalUtil.BUNDLE.getString("ssm.user.insert")))
				{
					this.msgSaveAction.saveUser(jsonData);
				}else if(jmsType.equalsIgnoreCase(ConstantFinalUtil.BUNDLE.getString("ssm.user.update")))
				{
					this.msgSaveAction.updateUser(jsonData);
				}else if(jmsType.equalsIgnoreCase(ConstantFinalUtil.BUNDLE.getString("ssm.user.delete")))
				{
					this.msgSaveAction.deleteUser(jsonData);
				}
			}
		}
	}
	
	public void setQueueName(String queueName)
	{
		this.queueName = queueName;
	}
	
	public void setJmsType(String jmsType)
	{
		this.jmsType = jmsType;
	}

	public void setJsonData(JSONObject jsonData)
	{
		this.jsonData = jsonData;
	}

}
