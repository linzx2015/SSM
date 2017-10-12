package com.lzx.ssm.queue.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 往消息队列发送消息
 * @author lzx
 * */
public interface IMessageProducerService
{
	/**
	 * 往对应队列发送json数据
	 * @param queueName 队列名称
	 * @param jmsType 消息头,区别不同的操作
	 * @param data 实际发送的消息体
	 * @return JSONObject
	 * */
	JSONObject sendMessageService(String queueName,String jmsTypeName,final JSONObject data);
}