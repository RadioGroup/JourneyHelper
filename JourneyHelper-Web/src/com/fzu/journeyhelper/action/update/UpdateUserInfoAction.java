package com.fzu.journeyhelper.action.update;

import com.fzu.journeyhelper.action.BaseAction;
import com.fzu.journeyhelper.domain.User;

public class UpdateUserInfoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int UPDATE_USER_INFO_STATUS_SUCCESS = 201; // 成功
	public static final int UPDATE_USER_INFO_STATUS_PASS_ERROR = 202;// 密码错误
	public static final int UPDATE_USER_INFO_STATUS_NOT_USER = 203; // 没有这样的用户

	private Integer status;
	private Integer userId;
	private String userName = null;
	private String passWord = null;
	private String nickName = null;
	private String realName = null;
	private String sex = null;
	private short age = 200;
	private String job = null;
	private String email = null;
	private String telephone = null;
	private String location = null;
	private String headUrl = null;
	private User user = null;

	public Integer getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String updateUserInfo() {

		User user = new User();
		user.setUserId(userId);
		user.setUserName(userName);
		user.setPassWord(passWord);
		user.setNickName(nickName);
		user.setRealName(realName);
		user.setSex(sex);
		user.setAge(age);
		user.setJob(job);
		user.setEmail(email);
		user.setTelephoneNumber(telephone);
		user.setLocation(location);
		user.setHeadUrl(headUrl);

		int ans = userManager.updateUserInfo(user);
		String res = SUCCESS;
		switch (ans) {
		case UPDATE_USER_INFO_STATUS_SUCCESS:
			status = UPDATE_USER_INFO_STATUS_SUCCESS;
			res = SUCCESS;
			break;
		case UPDATE_USER_INFO_STATUS_PASS_ERROR:
			status = UPDATE_USER_INFO_STATUS_PASS_ERROR;
			res = ERROR;
			break;
		case UPDATE_USER_INFO_STATUS_NOT_USER:
			status = UPDATE_USER_INFO_STATUS_NOT_USER;
			res = ERROR;
			break;
		}
		return res;
	}

}
