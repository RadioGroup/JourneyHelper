package com.fzu.journeyhelper.domain;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.domain.Route       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:05:55     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:05:55     
 * Modified Remark:     
 * @version   V1.0
 */
@Entity
@Table(name = "routes")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Route {

	// 标识属性 自增
	@Id
	@Column(name = "routeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer routeId;

	@Column(name = "title")
	private String title;

	@Column(name = "createTime")
	private Date createTime;

	@Column(name = "beginTime")
	private Date beginTime;

	@Column(name = "endTime")
	private Date endTime;

	@Column(name = "property")
	private String property;

	@Column(name = "type")
	private String type;

	@Column(name = "strong")
	private String strong;

	@Column(name = "imageUrl")
	private String imageUrl;

	@Column(name = "summary")
	private String summary;

	@Column(name = "content")
	private String content;

	// 行程列表
	@OneToMany(targetEntity = Itinerary.class, mappedBy = "route")
	private Set<Itinerary> itinerarys = new HashSet<Itinerary>();

	// 创建者
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "userId", nullable = false)
	private User createUser;

	// 队员列表
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "user_route", joinColumns = { @JoinColumn(name = "routeId", referencedColumnName = "routeId") }, inverseJoinColumns = { @JoinColumn(name = "userId", referencedColumnName = "userId") })
	private Set<User> users = new HashSet<User>();

	// 照片墙

	@OneToMany(targetEntity = Image.class, mappedBy = "route")
	private Set<Image> imageList = new HashSet<Image>();

	public Route() {

	}

	public Route(Integer routeId, String title, Date createTime,
			Date beginTime, Date endTime, String property, String type,
			String strong, String imageUrl, String summary, String content,
			User createUser, Set<User> users) {
		super();
		this.routeId = routeId;
		this.title = title;
		this.createTime = createTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.property = property;
		this.type = type;
		this.strong = strong;
		this.imageUrl = imageUrl;
		this.summary = summary;
		this.content = content;
		this.createUser = createUser;
		this.users = users;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStrong() {
		return strong;
	}

	public void setStrong(String strong) {
		this.strong = strong;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JSON(serialize = false)
	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	@JSON(serialize = false)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@JSON(serialize = false)
	public Set<Itinerary> getItinerarys() {
		return itinerarys;
	}

	public void setItinerarys(Set<Itinerary> itinerarys) {
		this.itinerarys = itinerarys;
	}

	@JSON(serialize = false)
	public Set<Image> getImageList() {
		return imageList;
	}

	public void setImageList(Set<Image> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "Route [id=" + routeId + ", title=" + title + ", createTime="
				+ createTime + ", beginTime=" + beginTime + ", endTime="
				+ endTime + ", property=" + property + ", type=" + type
				+ ", strong=" + strong + ", imageurl=" + imageUrl
				+ ", summary=" + summary + ", content=" + content
				+ ", createUser=" + createUser + ", users=" + users
				+ ", itinerarys=" + itinerarys + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Route other = (Route) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
