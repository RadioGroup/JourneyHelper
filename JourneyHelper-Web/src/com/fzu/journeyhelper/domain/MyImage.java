package com.fzu.journeyhelper.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.domain.MyImage       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:05:19     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:05:19     
 * Modified Remark:     
 * @version   V1.0
 */
@Entity
@Table(name = "images")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MyImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 代表标识属性
	@Id
	@Column(name = "imageId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer imageId;

	// 图片Url
	@Column(name = "imageUrl")
	private String imageURL;

	@Column(name = "createTime")
	private Date createTime;

	@ManyToOne(targetEntity = MyUser.class)
	@JoinColumn(name = "userId")
	private MyUser myUser;

	@ManyToOne(targetEntity = MyRoute.class)
	@JoinColumn(name = "routeId")
	private MyRoute myRoute;

	public MyUser getUser() {
		return myUser;
	}

	public void setUser(MyUser myUser) {
		this.myUser = myUser;
	}

	public MyRoute getRoute() {
		return myRoute;
	}

	public void setRoute(MyRoute myRoute) {
		this.myRoute = myRoute;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "MyImage [imageId=" + imageId + ", imageURL=" + imageURL
				+ ", createTime=" + createTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((imageURL == null) ? 0 : imageURL.hashCode());
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
		MyImage other = (MyImage) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		return true;
	}

}
