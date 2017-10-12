package com.lzx.ssm.queue.service.impl;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.util.ConstantFinalUtil;
import com.lzx.ssm.queue.service.IMessageProducerService;

@Service("messageProduceService")
public class MessageProducerServiceImpl implements IMessageProducerService
{
	@Resource(name="queueJmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueDestination")
    private Queue queueDestination;
    
	public JSONObject sendMessageService(final String queueName, final String jmsTypeName,final JSONObject data)
	{
		ConstantFinalUtil.loggerMsg.error("--发送的消息--{}",data);
		JSONObject resultJSON=new JSONObject();
		JmsTemplate jmsTemplate=getJmsTemplate();
    	try
		{
			//目的地、模版，都是通过注入方式引入，并不是通过配置bean的方式引入.
			jmsTemplate.send(queueName, new MessageCreator()
			{
				public Message createMessage(Session session) throws JMSException
				{
					ObjectMessage objMessage=session.createObjectMessage(data);
					objMessage.setJMSType(jmsTypeName);
					return objMessage;
				}
			});
			resultJSON.put("error_code", 0);
			resultJSON.put("data","发送成功!");
			return resultJSON;
		} catch (JmsException e)
		{
			try
			{
				//发送失败再尝试发送一次
				jmsTemplate.send(queueName, new MessageCreator()
				{
					public Message createMessage(Session session) throws JMSException
					{
						ObjectMessage objMessage=session.createObjectMessage(data);
						objMessage.setJMSType(jmsTypeName);
						return objMessage;
					}
				});
			} catch (JmsException e1)
			{
				//如果再发送失败,则返回发送失败提示
				resultJSON.put("error_code", 1);
				resultJSON.put("data","发送失败!"+e.toString());
				return resultJSON;
			}
			resultJSON.put("error_code", 0);
			resultJSON.put("data","发送成功!");
			return resultJSON;
		}
	}
	
	public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public Queue getDefaultDestination() {
        return queueDestination;
    }

    public void setDefaultDestination(Queue defaultDestination) {
        this.queueDestination = defaultDestination;
    }
}
