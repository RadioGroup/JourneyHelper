package com.fzu.action.authentication;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

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
		return "LoginAction [userName=" + userName + ", passWord=" + passWord
				+ "]";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

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
		return SUCCESS;
	}


}
