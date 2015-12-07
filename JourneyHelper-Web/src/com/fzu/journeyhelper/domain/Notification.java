package com.fzu.journeyhelper.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

/**
 * Notification entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "notification", catalog = "journeyhelperweb")
public class Notification implements java.io.Serializable {

	public static final short NOTIFICATION_STATUS_NOT_HANDLE = 1;
	public static final short NOTIFICATION_STATUS_HAS_HANDLE = 0;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer notificationId;
	private Route route;
	private User userBySendUserId;
	private User userByReceiveUserId;
	private short type;
	private String content;
	private short ishandle;
	private Date createTime;

	// Constructors

	/** default constructor */
	public Notification() {
	}

	/** minimal constructor */
	public Notification(User userByReceiveUserId, short type) {
		this.userByReceiveUserId = userByReceiveUserId;
		this.type = type;
	}

	/** full constructor */
	public Notification(Route route, User userBySendUserId,
			User userByReceiveUserId, short type, String content,
			short ishandle, Date createTime) {
		this.route = route;
		this.userBySendUserId = userBySendUserId;
		this.userByReceiveUserId = userByReceiveUserId;
		this.type = type;
		this.content = content;
		this.ishandle = ishandle;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "notificationId", unique = true, nullable = false)
	public Integer getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "routeId")
	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sendUserId")
	public User getUserBySendUserId() {
		return this.userBySendUserId;
	}

	public void setUserBySendUserId(User userBySendUserId) {
		this.userBySendUserId = userBySendUserId;
	}

	@JSON(serialize = false)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiveUserId", nullable = false)
	public User getUserByReceiveUserId() {
		return this.userByReceiveUserId;
	}

	public void setUserByReceiveUserId(User userByReceiveUserId) {
		this.userByReceiveUserId = userByReceiveUserId;
	}

	@Column(name = "type", nullable = false)
	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "ishandle")
	public short getIshandle() {
		return this.ishandle;
	}

	public void setIshandle(short ishandle) {
		this.ishandle = ishandle;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}