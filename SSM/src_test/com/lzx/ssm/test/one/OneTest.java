package com.lzx.ssm.test.one;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.test.BaseTest;
import com.lzx.ssm.common.util.ConstantFinalUtil;
import com.lzx.ssm.common.util.EncryptUtil;
import com.lzx.ssm.common.util.EnumUtil;
import com.lzx.ssm.one.pojo.User;
import com.lzx.ssm.one.service.OneUserService;
import com.lzx.ssm.queue.service.IMessageProducerService;

public class OneTest extends BaseTest
{
	@Resource
	private OneUserService userService;
	@Resource
	private IMessageProducerService messageProduceService;
	
	@Before
	public void init()
	{
		super.init();
		this.userService=(OneUserService) this.ac.getBean("userService");
		this.messageProduceService=(IMessageProducerService) this.ac.getBean("messageProduceService");
	}
	
	@Test
	public void userTest()
	{
		User user=new User();
		user.setUserId(this.getRandomUUID());
		user.setUserName("lzx");
		user.setUserAccount("linzx2015");
		user.setUserPassword(EncryptUtil.encodeStr("123456"));
		user.setUserSex(EnumUtil.MEN.getUnit());
		user.setUserAge(22);
		user.setUserCreator("admin");
		user.setUserDepartment("开发部");
		user.setUserPhone("15394415898");
		user.setUserEmail("857720446@qq.com");
		user.setUserCreateTime(new Date());
		user.setUserUpdateTime(new Date());
		user.setUserLastLoginTime(new Date());
		//JSONObject resultJSON=this.userService.insertOneService(user);
		messageProduceService.sendMessageService(ConstantFinalUtil.BUNDLE.getString("ssm.queue.user"),
				ConstantFinalUtil.BUNDLE.getString("ssm.user.insert"), user.toJSON());
		this.loggerMsg.info("--insert user---{}-");
	}
	
	@Test
	public void findOneUserTest()
	{
		Map<String,Object> paramMap=this.getParamMap();
		paramMap.put("userId", "d9bf7d617c9548f6909734622f5ded2a");
		User user=this.userService.findOneService(paramMap);
		this.loggerMsg.info("-user name--{}-",user.getUserName());
	}
	
	
	
	@After
	public void close()
	{
		super.close();
	}
}
