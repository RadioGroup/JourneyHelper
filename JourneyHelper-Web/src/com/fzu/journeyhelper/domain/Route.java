package com.fzu.journeyhelper.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Route entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "route", catalog = "journey")
public class Route implements java.io.Serializable {

	// Fields

	private Integer routeId;
	private User user;
	private String title;
	private String summary;
	private String article;
	private Date beginTime;
	private Date endTime;
	private Date createTime;
	private Set<Notification> notifications = new HashSet<Notification>(0);
	private Set<RouteComment> routeComments = new HashSet<RouteComment>(0);
	private Set<ImageUrl> imageUrls = new HashSet<ImageUrl>(0);
	private Set<Schedule> schedules = new HashSet<Schedule>(0);
	private Set<User> users = new HashSet<User>(0);
	private Set<ImageIssue> imageIssues = new HashSet<ImageIssue>(0);

	// Constructors

	/** default constructor */
	public Route() {
	}

	/** minimal constructor */
	public Route(User user) {
		this.user = user;
	}

	/** full constructor */
	public Route(User user, String title, String summary, String article,
			Date beginTime, Date endTime, Date createTime,
			Set<Notification> notifications, Set<RouteComment> routeComments,
			Set<ImageUrl> imageUrls, Set<Schedule> schedules, Set<User> users,
			Set<ImageIssue> imageIssues) {
		this.user = user;
		this.title = title;
		this.summary = summary;
		this.article = article;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.createTime = createTime;
		this.notifications = notifications;
		this.routeComments = routeComments;
		this.imageUrls = imageUrls;
		this.schedules = schedules;
		this.users = users;
		this.imageIssues = imageIssues;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "routeId", unique = true, nullable = false)
	public Integer getRouteId() {
		return this.routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "summary")
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "article", length = 65535)
	public String getArticle() {
		return this.article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Column(name = "beginTime", length = 19)
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "endTime", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "route")
	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "route")
	public Set<RouteComment> getRouteComments() {
		return this.routeComments;
	}

	public void setRouteComments(Set<RouteComment> routeComments) {
		this.routeComments = routeComments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "route")
	public Set<ImageUrl> getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(Set<ImageUrl> imageUrls) {
		this.imageUrls = imageUrls;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "route")
	public Set<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "routes")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "route")
	public Set<ImageIssue> getImageIssues() {
		return this.imageIssues;
	}

	public void setImageIssues(Set<ImageIssue> imageIssues) {
		this.imageIssues = imageIssues;
	}

}