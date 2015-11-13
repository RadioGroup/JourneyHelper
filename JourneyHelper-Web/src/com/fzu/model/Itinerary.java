package com.fzu.model;

import com.mysql.fabric.xmlrpc.base.Data;

public class Itinerary {

	private Integer id; //标识
	private Data beginTime;//开始时间
	private Data endTime;//结束时间
	private String origin;//起点
	private String destination;//终点
	private String transport;//交通工具
	private String accom;//住宿
	private String budget;//预算
	private String remark;//备注
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getAccom() {
		return accom;
	}
	public void setAccom(String accom) {
		this.accom = accom;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Itinerary [id=" + id  + ", beginTime="
				+ beginTime + ", endTime=" + endTime + ", origin=" + origin
				+ ", destination=" + destination + ", transport=" + transport
				+ ", accom=" + accom + ", budget=" + budget + ", remark="
				+ remark + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beginTime == null) ? 0 : beginTime.hashCode());
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
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
		Itinerary other = (Itinerary) obj;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		return true;
	}
	
	
	
	
}
