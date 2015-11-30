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
 * ImageUrl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "image_url", catalog = "journey")
public class ImageUrl implements java.io.Serializable {

	// Fields

	private Integer imageId;
	private Route route;
	private User user;
	private ImageIssue imageIssue;
	private String imageUrl;
	private Date createTime;

	// Constructors

	/** default constructor */
	public ImageUrl() {
	}

	/** full constructor */
	public ImageUrl(Route route, User user, ImageIssue imageIssue,
			String imageUrl, Date createTime) {
		this.route = route;
		this.user = user;
		this.imageIssue = imageIssue;
		this.imageUrl = imageUrl;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "imageId", unique = true, nullable = false)
	public Integer getImageId() {
		return this.imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
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
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "imageissueId")
	public ImageIssue getImageIssue() {
		return this.imageIssue;
	}

	public void setImageIssue(ImageIssue imageIssue) {
		this.imageIssue = imageIssue;
	}

	@Column(name = "imageUrl")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}