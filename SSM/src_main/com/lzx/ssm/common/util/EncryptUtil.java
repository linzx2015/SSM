package com.lzx.ssm.common.util;

import java.util.Random;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 加密工具类
 * @author lzx
 * */
public class EncryptUtil
{
	/**
	 * 用于生成随机数
	 * @param length生成的长度
	 * @return 生成的字符串
	 * */
	public static String productCode(int length)
	{
		StringBuffer sb=new StringBuffer();
		Random random=new Random();
		for(int i=0;i<length;i++)
		{
			int index=random.nextInt(ConstantFinalUtil.ALLSTR.length());
			char ch=ConstantFinalUtil.ALLSTR.charAt(index);
			sb.append(ch);
		}
		return sb.toString();
	}
	
	/**
	 * 进行加密操作
	 * $sha256$随机数$加密($sha256+随机数+明文)
	 * sha256$abcd$sha256(sha256$abcd$1111)
	 * @param sourcePass
	 * @return 加密后的字符串
	 * */
	public static String encodeStr(String sourcePass)
	{
		String encType="sha256";
		//生成32位的随机字符串
		String randStr=productCode(32);
		//拼装成加密字符串前缀
		String prefixStr=encType+"$"+randStr+"$";
		//真正待加密的前的字符串
		String beforeEncodeStr=prefixStr+sourcePass;
		//加密后的字符串
		String afterEncodeStr=DigestUtils.sha256Hex(beforeEncodeStr);
		afterEncodeStr=prefixStr+afterEncodeStr;
		ConstantFinalUtil.loggerMsg.info("encode: {}",afterEncodeStr);
		return afterEncodeStr;
	}
	
	/**
	 * 验证是否正确,对原待加密串再走一次加密流程,然后通过比较字符串进行验证
	 * sha256$p112mh8nzb177odj79ew5ihoubr7r5zz$e70bb37e6caa0fc8b6106f7e343f8467e93e2868f4263ab65215238724094321
	 * @param sourceStr:为加密前的源字符串
	 * @param encodeStr:为待验证的字符串
	 * */
	public static boolean checkEncodeStr(String sourceStr,String encodeStr)
	{
		//将字符串以$进行拆分,注意在windows下$为特殊字符需要转义
		String str[]=encodeStr.split("\\$");
		//加密前置字符串 $sha256$随机码
		String prefixStr=str[0]+"$"+str[1]+"$";
		//拼装成待加密的字符串 $sha256$随机码$源字符串
		String beforeEncodeStr=prefixStr+sourceStr;
		String afterEncodeStr=DigestUtils.sha256Hex(beforeEncodeStr);
		afterEncodeStr=prefixStr+afterEncodeStr;
		ConstantFinalUtil.loggerMsg.info("check: {}",afterEncodeStr);
		return afterEncodeStr.equalsIgnoreCase(encodeStr);
	}
	
	public static void main(String args[])
	{
		//String sourcePass="111111";
		String sourcePass="123456";
		String encodePass=DigestUtils.sha256Hex(sourcePass);
		ConstantFinalUtil.loggerMsg.info("sha256:"+encodePass);
		
		encodePass=EncryptUtil.encodeStr(sourcePass);
		ConstantFinalUtil.loggerMsg.info("check:{}",EncryptUtil.checkEncodeStr(sourcePass, encodePass));
	}
	
}