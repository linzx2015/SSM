package com.lzx.ssm.common.dao;

import java.util.List;
import java.util.Map;

/**
 * 公共父类接口
 * @author lzx
 * */
public interface IBaseMapper<T> {
	/**
	 * 新增一个对象
	 * 
	 * @param t
	 * @return int
	 * */
	int insertOne(T t);

	/**
	 * 修改一个对象
	 * 
	 * @param t
	 * @return int
	 * */
	int updateOne(T t);

	/**
	 * 删除一个对象
	 * 
	 * @param t
	 * @return int
	 * */
	int deleteOne(T t);

	/**
	 * 查询一个对象(名称或id)
	 * 
	 * @param paramMap
	 * @return T
	 * */
	T findOne(Map<String, Object> paramMap);

	/**
	 * 查询多个对象
	 * 
	 * @paramMap paramMap
	 * @return List<T>
	 * */
	List<T> findMulti(Map<String, Object> paramMap);
}
