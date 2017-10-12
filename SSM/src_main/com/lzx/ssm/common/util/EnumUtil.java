package com.lzx.ssm.common.util;

/**
 * 存放项目需要的枚举
 * 
 * @author lzx
 * */
public enum EnumUtil 
{
	// 时间单位枚举项
	MEN(Integer.valueOf("0"), "男"), 
	FEMALE(Integer.valueOf("1"),"女");
	
	// 状态值
	private int unit;
	// 提示信息
	private String info;

	private EnumUtil(int unit, String info)
	{
		this.unit = unit;
		this.info = info;
	}

	public int getUnit()
	{
		return unit;
	}

	public void setUnit(int unit)
	{
		this.unit = unit;
	}

	public String getInfo()
	{
		return info;
	}

	public void setInfo(String info)
	{
		this.info = info;
	}
}
