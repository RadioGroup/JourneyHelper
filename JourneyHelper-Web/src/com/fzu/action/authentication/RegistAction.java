package com.fzu.action.authentication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fzu.model.User;
import com.opensymphony.xwork2.Action;

public class RegistAction implements Action {

	private String userId;
	private String userName;
	private String passWord;
	private String nickName;
	private String Email;
	private String Telephone;
	private String headUrl;
	private User user;

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
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
				+ ", Email=" + Email + ", Telephone=" + Telephone
				+ ", headUrl=" + headUrl + "]";
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String regist() throws Exception {
		System.out.println(toString());
		user.setEmail(getEmail());
		user.setHeadUrl(getHeadUrl());
		user.setNickName(getNickName());
		user.setPassWord(getPassWord());
		user.setRoutelist(null);
		user.setTelephone(getTelephone());
		user.setUserId("" + getEmail().hashCode() + getUserName().hashCode());
		user.setUserName(getUserName());

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		//session.close();
		return SUCCESS;
	}

}
