package com.lzx.ssm.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 实现动态数据源切换
 * @author lzx
 * */
public class DynamicDataSource extends AbstractRoutingDataSource 
{
	@Override
	protected Object determineCurrentLookupKey() 
	{
		//切换对应的数据源
		return DataSourceContextHolder.getDataSource();
	}

}
