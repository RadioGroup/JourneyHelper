package com.fzu.journeyhelper.domain;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "journey", uniqueConstraints = @UniqueConstraint(columnNames = "userName"))
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String passWord;
	private String nickName;
	private String realName;
	private String sex;
	private short age;
	private String job;
	private String email;
	private String telephoneNumber;
	private String location;
	private Set<Notification> notificationsForReceiveUserId = new HashSet<Notification>(
			0);
	private Set<RouteComment> routeComments = new HashSet<RouteComment>(0);
	private Set<Route> routes = new HashSet<Route>(0);
	private Set<Notification> notificationsForSendUserId = new HashSet<Notification>(
			0);
	private Set<ImageIssue> imageIssues = new HashSet<ImageIssue>(0);
	private Set<Route> routes_1 = new HashSet<Route>(0);
	private Set<RouteCommentReplay> routeCommentReplaies = new HashSet<RouteCommentReplay>(
			0);
	private Set<ImageUrl> imageUrls = new HashSet<ImageUrl>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String passWord, String sex) {
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
	}

	/** full constructor */
	public User(String userName, String passWord, String nickName,
			String realName, String sex, short age, String job, String email,
			String telephoneNumber, String location,
			Set<Notification> notificationsForReceiveUserId,
			Set<RouteComment> routeComments, Set<Route> routes,
			Set<Notification> notificationsForSendUserId,
			Set<ImageIssue> imageIssues, Set<Route> routes_1,
			Set<RouteCommentReplay> routeCommentReplaies,
			Set<ImageUrl> imageUrls) {
		this.userName = userName;
		this.passWord = passWord;
		this.nickName = nickName;
		this.realName = realName;
		this.sex = sex;
		this.age = age;
		this.job = job;
		this.email = email;
		this.telephoneNumber = telephoneNumber;
		this.location = location;
		this.notificationsForReceiveUserId = notificationsForReceiveUserId;
		this.routeComments = routeComments;
		this.routes = routes;
		this.notificationsForSendUserId = notificationsForSendUserId;
		this.imageIssues = imageIssues;
		this.routes_1 = routes_1;
		this.routeCommentReplaies = routeCommentReplaies;
		this.imageUrls = imageUrls;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "userName", unique = true, nullable = false, length = 128)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "passWord", nullable = false, length = 128)
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "nickName")
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "realName")
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "sex", nullable = false, length = 8)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "age")
	public short getAge() {
		return this.age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	@Column(name = "job", length = 64)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telephoneNumber", length = 32)
	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	@Column(name = "location")
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByReceiveUserId")
	public Set<Notification> getNotificationsForReceiveUserId() {
		return this.notificationsForReceiveUserId;
	}

	public void setNotificationsForReceiveUserId(
			Set<Notification> notificationsForReceiveUserId) {
		this.notificationsForReceiveUserId = notificationsForReceiveUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<RouteComment> getRouteComments() {
		return this.routeComments;
	}

	public void setRouteComments(Set<RouteComment> routeComments) {
		this.routeComments = routeComments;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "route_user_relevance", catalog = "journey", joinColumns = { @JoinColumn(name = "userId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "routeId", nullable = false, updatable = false) })
	public Set<Route> getRoutes() {
		return this.routes;
	}

	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userBySendUserId")
	public Set<Notification> getNotificationsForSendUserId() {
		return this.notificationsForSendUserId;
	}

	public void setNotificationsForSendUserId(
			Set<Notification> notificationsForSendUserId) {
		this.notificationsForSendUserId = notificationsForSendUserId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ImageIssue> getImageIssues() {
		return this.imageIssues;
	}

	public void setImageIssues(Set<ImageIssue> imageIssues) {
		this.imageIssues = imageIssues;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Route> getRoutes_1() {
		return this.routes_1;
	}

	public void setRoutes_1(Set<Route> routes_1) {
		this.routes_1 = routes_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<RouteCommentReplay> getRouteCommentReplaies() {
		return this.routeCommentReplaies;
	}

	public void setRouteCommentReplaies(
			Set<RouteCommentReplay> routeCommentReplaies) {
		this.routeCommentReplaies = routeCommentReplaies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<ImageUrl> getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(Set<ImageUrl> imageUrls) {
		this.imageUrls = imageUrls;
	}

}