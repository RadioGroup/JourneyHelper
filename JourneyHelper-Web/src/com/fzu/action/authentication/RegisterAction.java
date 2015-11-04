package com.fzu.action.authentication;

import com.opensymphony.xwork2.Action;

public class RegisterAction implements Action {

	private String userName;
	private String passWord;

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
		return "RegisterAction [userName=" + userName + ", passWord="
				+ passWord + "]";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String register() throws Exception {
		System.out.println(toString());
		return SUCCESS;
	}


}
