package com.lzx.ssm.common.service.impl.one;

import com.lzx.ssm.common.datasource.DataSource;
import com.lzx.ssm.common.service.impl.BaseServiceImpl;

/**
 * 使用数据源ONE
 * @author lzx
 * */
@DataSource(value=DataSource.ONE)
public abstract class OneBaseServiceImpl extends BaseServiceImpl
{
}