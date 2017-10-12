package com.lzx.ssm.one.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String userId;
	private String userName;
	private String userAccount;
	private String userPassword;
	private int userSex;
	private int userAge;
	private String userCreator;
	private String userDepartment;
	private String userPhone;
	private String userEmail;
	private Date userCreateTime;
	private Date userUpdateTime;
	private Date userLastLoginTime;
	
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserAccount()
	{
		return userAccount;
	}
	public void setUserAccount(String userAccount)
	{
		this.userAccount = userAccount;
	}
	public String getUserPassword()
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	public int getUserSex()
	{
		return userSex;
	}
	public void setUserSex(int userSex)
	{
		this.userSex = userSex;
	}
	public int getUserAge()
	{
		return userAge;
	}
	public void setUserAge(int userAge)
	{
		this.userAge = userAge;
	}
	public String getUserCreator()
	{
		return userCreator;
	}
	public void setUserCreator(String userCreator)
	{
		this.userCreator = userCreator;
	}
	public String getUserDepartment()
	{
		return userDepartment;
	}
	public void setUserDepartment(String userDepartment)
	{
		this.userDepartment = userDepartment;
	}
	public String getUserPhone()
	{
		return userPhone;
	}
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}
	public String getUserEmail()
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public Date getUserCreateTime()
	{
		return userCreateTime;
	}
	public void setUserCreateTime(Date userCreateTime)
	{
		this.userCreateTime = userCreateTime;
	}
	public Date getUserUpdateTime()
	{
		return userUpdateTime;
	}
	public void setUserUpdateTime(Date userUpdateTime)
	{
		this.userUpdateTime = userUpdateTime;
	}
	public Date getUserLastLoginTime()
	{
		return userLastLoginTime;
	}
	public void setUserLastLoginTime(Date userLastLoginTime)
	{
		this.userLastLoginTime = userLastLoginTime;
	}
}
