package com.lzx.ssm.test.two;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.test.BaseTest;
import com.lzx.ssm.two.pojo.Video;
import com.lzx.ssm.two.service.TwoVideoService;

public class TwoTest extends BaseTest
{
	@Resource
	private TwoVideoService videoService;
	
	@Before
	public void init()
	{
		super.init();
		this.videoService=(TwoVideoService) this.ac.getBean("videoService");
	}
	
	@Test
	public void insertOneVideoTest()
	{
		Video video=new Video();
		video.setVideoId(this.getRandomUUID());
		video.setVideoName("权利的游戏");
		video.setVideoDescription("好像很好看的样子");
		video.setVideoCreateTime(new Date());
		video.setVideoUpdateTime(new Date());
		video.setVideoUrl("www.baidu.com/s????");
		JSONObject resultJSON=this.videoService.insertOneService(video);
		this.loggerMsg.info("--insert video--{}-",resultJSON);
	}
	
	@Test
	public void findOneVideoTest()
	{
		Map<String,Object> paramMap=this.getParamMap();
		paramMap.put("videoId", "c2a0f9aebe544476ac8195fbf4bf06d7");
		Video video=this.videoService.findOneService(paramMap);
		this.loggerMsg.info("-video name--{}-",video.getVideoName());
	}
	
	@After
	public void close()
	{
		super.close();
	}
}
