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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

/**
 * RouteComment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "route_comment", catalog = "journeyhelperweb")
public class RouteComment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer commentId;
	private Route route;
	private User user;
	private String content;
	private Date createTime;
	private Set<RouteCommentReplay> routeCommentReplaies = new HashSet<RouteCommentReplay>(
			0);

	// Constructors

	/** default constructor */
	public RouteComment() {
	}

	/** minimal constructor */
	public RouteComment(Route route, User user, String content) {
		this.route = route;
		this.user = user;
		this.content = content;
	}

	/** full constructor */
	public RouteComment(Route route, User user, String content,
			Date createTime, Set<RouteCommentReplay> routeCommentReplaies) {
		this.route = route;
		this.user = user;
		this.content = content;
		this.createTime = createTime;
		this.routeCommentReplaies = routeCommentReplaies;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "commentId", unique = true, nullable = false)
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "routeId", nullable = false)
	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@JSON(format="yyyy-MM-dd HH:mm")
	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JSON(serialize = false)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "routeComment")
	public Set<RouteCommentReplay> getRouteCommentReplaies() {
		return this.routeCommentReplaies;
	}

	public void setRouteCommentReplaies(
			Set<RouteCommentReplay> routeCommentReplaies) {
		this.routeCommentReplaies = routeCommentReplaies;
	}

}