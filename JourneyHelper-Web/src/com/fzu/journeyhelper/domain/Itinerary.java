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

@Entity
@Table(name = "itinerarys")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Itinerary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "itineraryId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itineraryId; // 标识

	@Column(name = "beginTime")
	private Date beginTime;// 开始时间

	@Column(name = "endTime")
	private Date endTime;// 结束时间

	@Column(name = "origin")
	private String origin;// 起点

	@Column(name = "destination")
	private String destination;// 终点

	@Column(name = "transport")
	private String transport;// 交通工具

	@Column(name = "accom")
	private String accom;// 住宿

	@Column(name = "budget")
	private String budget;// 预算

	@Column(name = "remark")
	private String remark;// 备注

	@ManyToOne(targetEntity=Route.class)
	@JoinColumn(name="routeId")
	private Route route;
	
	
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Integer getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(Integer itineraryId) {
		this.itineraryId = itineraryId;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
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
		return "Itinerary [id=" + itineraryId + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", origin=" + origin
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
