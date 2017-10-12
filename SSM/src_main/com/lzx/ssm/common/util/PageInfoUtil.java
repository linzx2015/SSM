package com.lzx.ssm.common.util;


/**
 * 分页工具类
 * @author lzx
 * */
public class PageInfoUtil
{
	//** 代表不需要set方法
	//总记录数  
	private int totalRecord;
	//每页多少条记录
	private int pageSize=10;
	//当前页
	private int currentPage;
	//上一页    	**
	private int prePage;
	//下一页 	**
	private int nextPage;
	//总页数    	**
	private int totalPage;
	//当前页的记录数   **
	private int currentRecord;
	
	public int getTotalRecord()
	{
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	//对当期页进行处理
	public int getCurrentPage()
	{
		if(this.currentPage<1)
		{
			this.currentPage=1;
		}
		//当前页大于总页数,并且总页数要大于0,则当前页为总页数
		if(this.currentPage>this.getTotalPage() && this.getTotalPage()>0)
		{
			this.currentPage=this.getTotalPage();
		}
		return currentPage;
	}
	public void setCurrentPage(int currenPage)
	{
		this.currentPage = currenPage;
	}
	
	public int getPrePage()
	{
		//上一页即为当前页减1
		this.prePage=this.getCurrentPage()-1;
		//如果上一页小于1,则上一页为当前页
		if(this.prePage<1)
		{
			this.prePage=1;
		}
		return prePage;
	}
	public int getNextPage()
	{
		//下一页即为当前页加1
		this.nextPage=this.currentPage+1;
		//如果下一页比总页数大,则只下一页为总页数
		if(this.nextPage>this.getTotalPage() && this.getTotalPage()>0)
		{
			this.nextPage=this.getTotalPage();
		}
		return nextPage;
	}
	
	//获得总页数 总记录数/每页大小
	public int getTotalPage()
	{
		//得到的结果可能为小数,因此需要向上取整
		this.totalPage=(int)Math.ceil(this.getTotalRecord()*1.0/this.pageSize);
		return totalPage;
	}
	public int getCurrentRecord()
	{
		/*等差数列
		 * 1   10
		 * 11  10
		 * 21  10
		 * */
		this.currentRecord=(this.getCurrentPage()-1)*this.pageSize;
		return currentRecord;
	}
	
	@Override
	public String toString()
	{
		return "PageInfoUtil [totalRecord=" + totalRecord + ", pageSize=" + pageSize + ", currentPage=" + this.getCurrentPage()
				+ ", prePage=" + this.getPrePage() + ", nextPage=" + this.getNextPage() + ", totalPage=" + this.getTotalPage() + ", currentRecord="
				+ this.getCurrentRecord() + "]";
	}

	public static void main(String[] args)
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		pageInfoUtil.setTotalRecord(22);
		pageInfoUtil.setPageSize(10);
		pageInfoUtil.setCurrentPage(3);
		
		System.out.println(pageInfoUtil);
	}
	
	
}
