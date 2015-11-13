package com.fzu.model;

import com.mysql.fabric.xmlrpc.base.Data;

public class Image {
	
	private Integer id;
	private String imageURL;
	private Data createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public Data getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Data createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", imageURL=" + imageURL + ", createTime="
				+ createTime + "]";
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
		Image other = (Image) obj;
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
