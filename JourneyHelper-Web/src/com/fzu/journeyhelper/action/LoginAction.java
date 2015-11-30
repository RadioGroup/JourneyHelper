package com.fzu.journeyhelper.action;

import com.fzu.journeyhelper.domain.MyUser;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.action.LoginAction       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:03:43     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:03:43     
 * Modified Remark:     
 * @version   V1.0
 */
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 登录状态标记
	// 201登录成功
	// 202账号或者密码错误
	private int status;
	private MyUser myUser;
	private String userName;
	private String passWord;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	@Override
	public String toString() {
		return "LoginAction [userName=" + userName + ", passWord=" + passWord
				+ "]";
	}

	@Override
	public String execute() throws Exception {

		return SUCCESS;

	}

	public String userLogin() throws Exception {
		System.out.println(toString());

		myUser = new MyUser();
		myUser.setUserName(getUserName());
		myUser.setPassWord(getPassWord());

		MyUser u = userManager.loginAuthen(myUser);
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
