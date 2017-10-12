package com.lzx.ssm.common.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lzx.ssm.common.base.Base;

/**
 * 父测试类
 * @author lzx
 * */
public abstract class BaseTest extends Base
{
	protected ApplicationContext ac;

	@Before
	public void init()
	{
		this.ac=new ClassPathXmlApplicationContext("classpath*:spring/applicationContext_common.xml");
		this.loggerMsg.info("--init--{}",this.ac);
	}
	
	@Test
	public void test()
	{
		this.loggerMsg.info("--test--");
	}
	
	@After
	public void close()
	{
		ClassPathXmlApplicationContext cpxac=(ClassPathXmlApplicationContext) this.ac;
		cpxac.close();		
		this.loggerMsg.info("--close--");
	}
}
