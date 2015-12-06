package com.fzu.journeyhelper.action;

import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon Project Name: JourneyHelper-Web
 * 
 * Description: ClassName: com.fzu.journeyhelper.action.RegistAction Author:
 * Hoatson Create Time: 2015年11月20日 下午6:03:50 Modified By: Modified Time:
 * 2015年11月20日 下午6:03:50 Modified Remark:
 * 
 * @version V1.0
 */
public class RegistAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 301注册成功
	// 302用户名存在
	private Integer status;
	private String userName;
	private String passWord;
	private String nickName;
	private String realName;
	private String sex;
	private short age;
	private String job;
	private String email;
	private String telephone;
	private String location;
	private String headUrl;
	private User user;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String userRegist() throws Exception {
		System.out.println(toString());
		user = new User();
		user.setUserName(getUserName());
		user.setPassWord(getPassWord());
		user.setNickName(getNickName());
		user.setRealName(getRealName());
		if(getSex().equals("女")){			
			user.setSex("女");
		}else{
			user.setSex("男");
		}
		user.setAge(getAge());	
		user.setJob(getJob());
		user.setEmail(getEmail());
		user.setTelephoneNumber(getTelephone());
		user.setLocation(getLocation());
		user.setHeadUrl(getHeadUrl());
	
		// 先查询改用户名是否可用
		if (userManager.registAvaliable(user)) {
			userManager.registNewUser(user);
			setStatus(301);
			return SUCCESS;
		} else {
			setStatus(302);
			return ERROR;
		}

	}

}
