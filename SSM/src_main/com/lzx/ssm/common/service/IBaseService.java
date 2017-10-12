package com.lzx.ssm.common.service;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.util.PageInfoUtil;

/**
 * 公共服务接口
 * @author lzx
 * */
public interface IBaseService<T> 
{
	/**
	 * 插入一条记录服务
	 * @param t
	 * @return JSONObject 格式{code:"1",info:"添加成功",data:{effectRows:"11","id":"11"}}
	 * */
	JSONObject insertOneService(T t);
	
	/**
	 * 更新一条记录服务
	 * @param t
	 * @return JSONObject 格式{code:"1",info:"添加成功",data:{effectRows:"11","id":"11"}}
	 * */
	JSONObject updateOneService(T t);
	
	/**
	 * 删除一条记录服务
	 * @param t
	 * @return JSONObject 格式{code:"1",info:"添加成功",data:{effectRows:"11","id":"11"}}
	 * */
	JSONObject deleteOneService(T t);
	
	/**
	 * 查询一条记录服务
	 * @param paramMap
	 * @return T
	 * */
	public T findOneService(Map<String,Object> paramMap);
	
	/**
	 * 查询多条记录服务
	 * @param paramMap
	 * @return List<T>
	 * */
	public List<T> findMultiService(Map<String,Object> paramMap,PageInfoUtil pageInfoUtil);
}
