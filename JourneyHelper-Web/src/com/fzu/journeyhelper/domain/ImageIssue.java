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
 * ImageIssue entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "image_issue", catalog = "journey")
public class ImageIssue implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	private Integer imageIssueId;
	private Route route;
	private User user;
	private Date createTime;
	private Set<ImageUrl> imageUrls = new HashSet<ImageUrl>(0);

	// Constructors

	/** default constructor */
	public ImageIssue() {
	}

	/** full constructor */
	public ImageIssue(Route route, User user, Date createTime,
			Set<ImageUrl> imageUrls) {
		this.route = route;
		this.user = user;
		this.createTime = createTime;
		this.imageUrls = imageUrls;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "imageIssueId", unique = true, nullable = false)
	public Integer getImageIssueId() {
		return this.imageIssueId;
	}

	public void setImageIssueId(Integer imageIssueId) {
		this.imageIssueId = imageIssueId;
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

	@Column(name = "createTime", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JSON(serialize = false)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "imageIssue")
	public Set<ImageUrl> getImageUrls() {
		return this.imageUrls;
	}

	public void setImageUrls(Set<ImageUrl> imageUrls) {
		this.imageUrls = imageUrls;
	}

}