package com.lzx.ssm.one.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.service.impl.one.OneBaseServiceImpl;
import com.lzx.ssm.common.util.PageInfoUtil;
import com.lzx.ssm.one.mapper.OneUserMapper;
import com.lzx.ssm.one.pojo.User;
import com.lzx.ssm.one.service.OneUserService;

@Service("userService")
public class OneUserServiceImpl extends OneBaseServiceImpl implements OneUserService
{
	@Resource
	private OneUserMapper userMapper;
	
	public JSONObject insertOneService(User user)
	{
		this.clearJSON();
		int res = userMapper.insertOne(user);
		if (res > 0)
		{
			resultJSON.put("error_code", "0");
			resultJSON.put("data", "插入成功");
			dataJSON.put("id", user.getUserId());
			dataJSON.put("effectRows", res);
			resultJSON.put("info", dataJSON);
		} else
		{
			resultJSON.put("error_code", "1");
			resultJSON.put("data", "插入失败");
		}
		return resultJSON;
	}

	public JSONObject updateOneService(User user)
	{
		this.clearJSON();
		int res = userMapper.updateOne(user);
		if (res > 0)
		{
			resultJSON.put("error_code", "0");
			resultJSON.put("data", "更新成功");
			dataJSON.put("id", user.getUserId());
			dataJSON.put("effectRows", res);
			resultJSON.put("info", dataJSON);
		} else
		{
			resultJSON.put("error_code", "1");
			resultJSON.put("data", "更新失败");
		}
		return resultJSON;
	}
	
	public JSONObject deleteOneService(User user)
	{
		this.clearJSON();
		int res = userMapper.deleteOne(user);
		if (res > 0)
		{
			resultJSON.put("error_code", "0");
			resultJSON.put("data", "删除成功");
			dataJSON.put("id", user.getUserId());
			dataJSON.put("effectRows", res);
			resultJSON.put("info", dataJSON);
		} else
		{
			resultJSON.put("error_code", "1");
			resultJSON.put("data", "删除失败");
		}
		return resultJSON;
	}

	public User findOneService(Map<String, Object> paramMap)
	{
		return this.userMapper.findOne(paramMap);
	}
	
	public List<User> findMultiService(Map<String, Object> paramMap,PageInfoUtil pageInfoUtil)
	{
		//模糊查询的拼接由后台进行控制,避免用户乱输入
		if(paramMap.get("keywords")!=null)
		{
			paramMap.put("keywords","%"+paramMap.get("keywords")+"%");
		}
		//进行分页
		if(pageInfoUtil!=null)
		{
			//先查询全部记录
			paramMap.put("pageCond", "true");
			List<User> userList=this.userMapper.findMulti(paramMap);
			//查出总记录数
			if(userList.size()==1)
			{
				//总记录数已经存放在id中
				pageInfoUtil.setTotalRecord(Integer.parseInt(userList.get(0).getUserId()));
			}
			paramMap.put("sort_column",paramMap.get("sort_column"));
			paramMap.put("sort_type",paramMap.get("sort_type"));
			paramMap.put("pageCond", "false");
			paramMap.put("page", pageInfoUtil.getCurrentRecord());
			paramMap.put("pagenum", pageInfoUtil.getPageSize());
			return this.userMapper.findMulti(paramMap);
		}
		return this.userMapper.findMulti(paramMap);
	}
}
