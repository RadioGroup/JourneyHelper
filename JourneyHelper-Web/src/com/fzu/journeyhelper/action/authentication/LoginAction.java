package com.fzu.journeyhelper.action.authentication;

import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.impl.UserManager;
import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

	// private static final int LOGIN_SUCCESS = 201;
	// private static final int LOGIN_ERROT= 202;

	// µÇÂ¼×´Ì¬±ê¼Ç
	// 201µÇÂ¼³É¹¦
	// 202ÕËºÅ»òÕßÃÜÂë´íÎó
	private int status;
	private User user;
	private String userName;
	private String passWord;
	private UserManager userManager;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Override
	public String toString() {
		return "LoginAction [userName=" + userName + ", passWord=" + passWord
				+ "]";
	}

	@Override
	public String execute() throws Exception {

		System.out.println(getUserName());
		System.out.println(getPassWord());

		if (getPassWord().equals("2")) {
			System.out.println("error");
			return ERROR;
		} else {
			System.out.println("success");
			return SUCCESS;
		}

	}

	public String login() throws Exception {
		System.out.println(toString());

		user.setUserName(getUserName());
		user.setPassWord(getPassWord());

		User u = userManager.loginAuthen(user);
		if (u != null) {
			setUser(u);
			setStatus(201);
			return SUCCESS;
		} else {
			setStatus(202);
			return ERROR;
		}

	}

}
