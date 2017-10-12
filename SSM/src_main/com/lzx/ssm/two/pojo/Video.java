package com.lzx.ssm.two.pojo;

import java.util.Date;

public class Video
{
	private String videoId;
	private String videoName;
	private String videoUrl;
	private String videoDescription;
	private Date videoCreateTime;
	private Date videoUpdateTime;
	
	public String getVideoId()
	{
		return videoId;
	}
	public void setVideoId(String videoId)
	{
		this.videoId = videoId;
	}
	public String getVideoName()
	{
		return videoName;
	}
	public void setVideoName(String videoName)
	{
		this.videoName = videoName;
	}
	public String getVideoUrl()
	{
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl)
	{
		this.videoUrl = videoUrl;
	}
	public String getVideoDescription()
	{
		return videoDescription;
	}
	public void setVideoDescription(String videoDescription)
	{
		this.videoDescription = videoDescription;
	}
	public Date getVideoCreateTime()
	{
		return videoCreateTime;
	}
	public void setVideoCreateTime(Date videoCreateTime)
	{
		this.videoCreateTime = videoCreateTime;
	}
	public Date getVideoUpdateTime()
	{
		return videoUpdateTime;
	}
	public void setVideoUpdateTime(Date videoUpdateTime)
	{
		this.videoUpdateTime = videoUpdateTime;
	}
}
