package com.fzu.journeyhelper.action;

import com.fzu.journeyhelper.domain.User;

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
	private User user;


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		user = new User();
		user.setEmail(getEmail());
		user.setHeadUrl(getHeadUrl());
		user.setNickName(getNickName());
		user.setPassWord(getPassWord());
		user.setTelephone(getTelephone());
		user.setUserName(getUserName());

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
