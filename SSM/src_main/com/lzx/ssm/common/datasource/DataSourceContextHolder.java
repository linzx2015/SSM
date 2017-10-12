package com.lzx.ssm.common.datasource;

import com.lzx.ssm.common.util.ConstantFinalUtil;

/**
 * 数据库选择工具
 * @author: lzx
 */
public class DataSourceContextHolder {
	//存储对应数据库
	private static final ThreadLocal<String> dataSourceContextHolder = new ThreadLocal<String>();

	/**
	 * 设置数据源
	 * @param dataSource
	 * */
	public static void setDataSource(String dataSource) {
		ConstantFinalUtil.loggerMsg.info("--set-ds--{}",dataSource);
		dataSourceContextHolder.set(dataSource);
	}

	public static String getDataSource() {
		String dataSource=((String) dataSourceContextHolder.get());
		ConstantFinalUtil.loggerMsg.info("--get-ds--{}",dataSource);
		return dataSource;
	}
	
	/**
	 * 清除数据源
	 * */
	public static void clearDataSource() {
		dataSourceContextHolder.remove();
	}
}
