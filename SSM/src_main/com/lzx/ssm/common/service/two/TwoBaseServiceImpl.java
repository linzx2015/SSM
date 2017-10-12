package com.lzx.ssm.common.service.two;

import com.lzx.ssm.common.datasource.DataSource;
import com.lzx.ssm.common.service.BaseServiceImpl;

/**
 * 使用数据源TWO
 * @author lzx
 * **/
@DataSource(value=DataSource.TWO)
public abstract class TwoBaseServiceImpl extends BaseServiceImpl
{
}
