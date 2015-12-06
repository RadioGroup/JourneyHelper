package com.fzu.journeyhelper.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RouteCommentReplay entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "route_comment_replay", catalog = "journey")
public class RouteCommentReplay implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	private Integer replayId;
	private RouteComment routeComment;
	private User user;
	private String content;
	private Date createTime;

	// Constructors

	/** default constructor */
	public RouteCommentReplay() {
	}

	/** minimal constructor */
	public RouteCommentReplay(RouteComment routeComment, User user) {
		this.routeComment = routeComment;
		this.user = user;
	}

	/** full constructor */
	public RouteCommentReplay(RouteComment routeComment, User user,
			String content, Date createTime) {
		this.routeComment = routeComment;
		this.user = user;
		this.content = content;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "replayId", unique = true, nullable = false)
	public Integer getReplayId() {
		return this.replayId;
	}

	public void setReplayId(Integer replayId) {
		this.replayId = replayId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "commentId", nullable = false)
	public RouteComment getRouteComment() {
		return this.routeComment;
	}

	public void setRouteComment(RouteComment routeComment) {
		this.routeComment = routeComment;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}