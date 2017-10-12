package com.lzx.ssm.queue.reciver;

import javax.jms.Message;
import javax.jms.MessageListener;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.util.ConstantFinalUtil;
import com.lzx.ssm.common.util.SpringContextUtil;
import com.lzx.ssm.common.util.ThreadUtil;

/**
 * 点对点消息消费者 
 */
@Component("queueConsume")
public class MessageConsumer implements MessageListener 
{
	@Autowired  
	private SpringContextUtil springContextUtil;  
	
	 public void onMessage(Message message) {
		try
		{
			ActiveMQDestination queueDestion=(ActiveMQDestination) message.getJMSDestination();
			//取出队列名称根据队列名称进行判断
			String queueName=queueDestion.getPhysicalName();
			ActiveMQObjectMessage om = (ActiveMQObjectMessage) message;
			JSONObject jsonData=(JSONObject) om.getObject();
			String jmsType=om.getJMSType();
			
			ConstantFinalUtil.loggerMsg.info("---收到的消息-queue-{}-type-{}-json-{}",queueName,jmsType,jsonData);
			ThreadUtil threadUtil=(ThreadUtil) springContextUtil.getBean("threadUtil");
			//不做处理,直接交给线程完成
			threadUtil.setQueueName(queueName);
			threadUtil.setJmsType(jmsType);
			threadUtil.setJsonData(jsonData);
		    //由线程执行数据操作
			ConstantFinalUtil.executorService.execute(threadUtil);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
    }
}
