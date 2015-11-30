package com.fzu.journeyhelper.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.domain.MyUser       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:06:02     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:06:02     
 * Modified Remark:     
 * @version   V1.0
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "userName" }))
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MyUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 添加用户表示属性 自增
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	// 上诉增加了唯一约束
	@Column(name = "userName")
	private String userName;

	@Column(name = "passWord")
	private String passWord;

	@Column(name = "nickName")
	private String nickName;

	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "headUrl")
	private String headUrl;

	// 用户上传的照片
	@OneToMany(targetEntity = MyImage.class, mappedBy = "user")
	private Set<MyImage> imageList = new HashSet<MyImage>();

	// 用户的旅行记录
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "user_route", joinColumns = { @JoinColumn(name = "userId", referencedColumnName = "userId") }, inverseJoinColumns = { @JoinColumn(name = "routeId", referencedColumnName = "routeId") })
	private Set<MyRoute> routelist = new HashSet<MyRoute>();

	// 用户创建记录
	@OneToMany(targetEntity = MyRoute.class, mappedBy = "createUser")
	private Set<MyRoute> createlist = new HashSet<MyRoute>();

	public MyUser() {

	}

	public MyUser(Integer userId, String userName, String passWord,
			String nickName, String email, String telephone, String headUrl,
			Set<MyRoute> routelist) {
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

	@JSON(serialize = false)
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

	@JSON(serialize = false)
	public Set<MyImage> getImageList() {
		return imageList;
	}

	public void setImageList(Set<MyImage> imageList) {
		this.imageList = imageList;
	}

	@JSON(serialize = false)
	public Set<MyRoute> getRoutelist() {
		return routelist;
	}

	public void setRoutelist(Set<MyRoute> routelist) {
		this.routelist = routelist;
	}

	@JSON(serialize = false)
	public Set<MyRoute> getCreatelist() {
		return createlist;
	}

	public void setCreatelist(Set<MyRoute> createlist) {
		this.createlist = createlist;
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
		MyUser other = (MyUser) obj;
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
