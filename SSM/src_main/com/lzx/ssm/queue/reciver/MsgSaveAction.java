package com.lzx.ssm.queue.reciver;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.base.Base;
import com.lzx.ssm.one.pojo.User;
import com.lzx.ssm.one.service.OneUserService;
/***
 * 保存消息的动作
 * @author lzx
 * */
@Component("msgSaveAction")
public class MsgSaveAction extends Base
{
	@Resource
	private OneUserService userService;
	
	public void saveUser(JSONObject json)
	{
		User user=json.toJavaObject(User.class);
		JSONObject resultJSON=this.userService.insertOneService(user);
		this.loggerMsg.info("-recive user--{}-",resultJSON);
	}
	
	public void updateUser(JSONObject json)
	{
		User user=json.toJavaObject(User.class);
		JSONObject resultJSON=this.userService.insertOneService(user);
		this.loggerMsg.info("-recive user--{}-",resultJSON);
	}
	
	public void deleteUser(JSONObject json)
	{
		User user=json.toJavaObject(User.class);
		JSONObject resultJSON=this.userService.insertOneService(user);
		this.loggerMsg.info("-recive user--{}-",resultJSON);
	}
}
