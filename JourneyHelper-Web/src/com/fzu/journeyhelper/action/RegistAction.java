package com.fzu.journeyhelper.action;

import com.fzu.journeyhelper.domain.MyUser;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.action.RegistAction       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:03:50     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:03:50     
 * Modified Remark:     
 * @version   V1.0
 */
public class RegistAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 301注册成功
	// 302用户名存在
	private Integer status;

	private Integer userId;
	private String userName;
	private String passWord;
	private String nickName;
	private String email;
	private String telephone;
	private String headUrl;
	private MyUser myUser;


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MyUser getUser() {
		return myUser;
	}

	public void setUser(MyUser myUser) {
		this.myUser = myUser;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	@Override
	public String toString() {
		return "RegistAction [userId=" + userId + ", userName=" + userName
				+ ", passWord=" + passWord + ", nickName=" + nickName
				+ ", email=" + email + ", telephone=" + telephone
				+ ", headUrl=" + headUrl + "]";
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String userRegist() throws Exception {
		System.out.println(toString());
		myUser = new MyUser();
		myUser.setEmail(getEmail());
		myUser.setHeadUrl(getHeadUrl());
		myUser.setNickName(getNickName());
		myUser.setPassWord(getPassWord());
		myUser.setTelephone(getTelephone());
		myUser.setUserName(getUserName());

		// 先查询改用户名是否可用
		if (userManager.registAvaliable(myUser)) {
			userManager.registNewUser(myUser);
			setStatus(301);
			return SUCCESS;
		} else {
			setStatus(302);
			return ERROR;
		}

	}

}
