package com.fzu.model;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer userId;
	private String userName;
	private String passWord;
	private String nickName;
	private String email;
	private String telephone;
	private String headUrl;

	// 用户的旅行记录
	private Set<Route> routelist = new HashSet<Route>();
	// 用户创建记录
	private Set<Route> createlist = new HashSet<Route>();
	// 用户上传的照片
	private Set<Image> imageList = new HashSet<Image>();

	public User() {

	}

	public User(Integer userId, String userName, String passWord,
			String nickName, String email, String telephone, String headUrl,
			Set<Route> routelist) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.nickName = nickName;
		this.email = email;
		this.telephone = telephone;
		this.headUrl = headUrl;
		this.routelist = routelist;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Set<Route> getRoutelist() {
		return routelist;
	}

	public void setRoutelist(Set<Route> routelist) {
		this.routelist = routelist;
	}

	public Set<Route> getCreatelist() {
		return createlist;
	}

	public void setCreatelist(Set<Route> createlist) {
		this.createlist = createlist;
	}

	public Set<Image> getImageList() {
		return imageList;
	}

	public void setImageList(Set<Image> imageList) {
		this.imageList = imageList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
