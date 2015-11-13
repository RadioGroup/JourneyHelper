package com.fzu.model;

import java.util.HashSet;
import java.util.Set;

import com.mysql.fabric.xmlrpc.base.Data;

public class Route {

	private Integer id;
	private String title;
	private Data createTime;
	private Data beginTime;
	private Data endTime;
	private String property;
	private String type;
	private String strong;
	private String imageurl;
	private String summary;
	private String content;

	// 创建者
	private User createUser;
	// 队员列表
	private Set<User> teamrecod = new HashSet<User>();
	//行程列表
	private Set<Itinerary> itinerarys = new HashSet<Itinerary>();
	//照片墙
	private Set<Image> imageList = new HashSet<Image>();
	
	
	public Route() {

	}

	public Route(Integer id, String title, Data createTime, Data beginTime,
			Data endTime, String property, String type, String strong,
			String imageurl, String summary, String content, User createUser,
			Set<User> teamrecod) {
		super();
		this.id = id;
		this.title = title;
		this.createTime = createTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.property = property;
		this.type = type;
		this.strong = strong;
		this.imageurl = imageurl;
		this.summary = summary;
		this.content = content;
		this.createUser = createUser;
		this.teamrecod = teamrecod;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Data getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}

	public Data getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Data beginTime) {
		this.beginTime = beginTime;
	}

	public Data getEndTime() {
		return endTime;
	}

	public void setEndTime(Data endTime) {
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

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
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

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public Set<User> getTeamrecod() {
		return teamrecod;
	}

	public void setTeamrecod(Set<User> teamrecod) {
		this.teamrecod = teamrecod;
	}
	
	
	public Set<Itinerary> getItinerarys() {
		return itinerarys;
	}

	public void setItinerarys(Set<Itinerary> itinerarys) {
		this.itinerarys = itinerarys;
	}

	

	public Set<Image> getImageList() {
		return imageList;
	}

	public void setImageList(Set<Image> imageList) {
		this.imageList = imageList;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", title=" + title + ", createTime="
				+ createTime + ", beginTime=" + beginTime + ", endTime="
				+ endTime + ", property=" + property + ", type=" + type
				+ ", strong=" + strong + ", imageurl=" + imageurl
				+ ", summary=" + summary + ", content=" + content
				+ ", createUser=" + createUser + ", teamrecod=" + teamrecod
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
