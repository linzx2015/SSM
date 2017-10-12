package com.lzx.ssm.two.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONObject;
import com.lzx.ssm.common.service.impl.two.TwoBaseServiceImpl;
import com.lzx.ssm.common.util.PageInfoUtil;
import com.lzx.ssm.two.mapper.TwoVideoMapper;
import com.lzx.ssm.two.pojo.Video;
import com.lzx.ssm.two.service.TwoVideoService;

@Service("videoService")
public class TwoVideoServiceImpl extends TwoBaseServiceImpl implements TwoVideoService
{
	@Resource
	private TwoVideoMapper videoMapper;

	public JSONObject insertOneService(Video video)
	{
		this.clearJSON();
		int res = videoMapper.insertOne(video);
		if (res > 0)
		{
			resultJSON.put("error_code", "0");
			resultJSON.put("data", "插入成功");
			dataJSON.put("id", video.getVideoId());
			dataJSON.put("effectRows", res);
			resultJSON.put("info", dataJSON);
		} else
		{
			resultJSON.put("error_code", "1");
			resultJSON.put("data", "插入失败");
		}
		return resultJSON;
	}

	public JSONObject updateOneService(Video video)
	{
		this.clearJSON();
		int res = videoMapper.updateOne(video);
		if (res > 0)
		{
			resultJSON.put("error_code", "0");
			resultJSON.put("data", "更新成功");
			dataJSON.put("id", video.getVideoId());
			dataJSON.put("effectRows", res);
			resultJSON.put("info", dataJSON);
		} else
		{
			resultJSON.put("error_code", "1");
			resultJSON.put("data", "更新失败");
		}
		return resultJSON;
	}

	public JSONObject deleteOneService(Video video)
	{
		this.clearJSON();
		int res = videoMapper.deleteOne(video);
		if (res > 0)
		{
			resultJSON.put("error_code", "0");
			resultJSON.put("data", "删除成功");
			dataJSON.put("id", video.getVideoId());
			dataJSON.put("effectRows", res);
			resultJSON.put("info", dataJSON);
		} else
		{
			resultJSON.put("error_code", "1");
			resultJSON.put("data", "删除失败");
		}
		return resultJSON;
	}

	public Video findOneService(Map<String, Object> paramMap)
	{
		return videoMapper.findOne(paramMap);
	}
	
	public List<Video> findMultiService(Map<String, Object> paramMap,PageInfoUtil pageInfoUtil)
	{
		//模糊查询的拼接由后台进行控制,避免用户乱输入
		if(paramMap.get("keywords")!=null)
		{
			paramMap.put("keywords","%"+paramMap.get("keywords")+"%");
		}
		//进行分页
		if(pageInfoUtil!=null)
		{
			//先查询全部记录
			paramMap.put("pageCond", "true");
			List<Video> videoList=this.videoMapper.findMulti(paramMap);
			//查出总记录数
			if(videoList.size()==1)
			{
				//总记录数已经存放在id中
				pageInfoUtil.setTotalRecord(Integer.parseInt(videoList.get(0).getVideoId()));
			}
			paramMap.put("sort_column",paramMap.get("sort_column"));
			paramMap.put("sort_type",paramMap.get("sort_type"));
			paramMap.put("pageCond", "false");
			paramMap.put("page", pageInfoUtil.getCurrentRecord());
			paramMap.put("pagenum", pageInfoUtil.getPageSize());
			return this.videoMapper.findMulti(paramMap);
		}
		return this.videoMapper.findMulti(paramMap);
	}

	
}
