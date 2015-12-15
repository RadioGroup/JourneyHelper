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

import org.apache.struts2.json.annotations.JSON;

/**
 * Schedule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "schedule", catalog = "journeyhelperweb")
public class Schedule implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	private Integer schedulingId;
	private Route route;
	private String destination;
	private Date beginTime;
	private Date endTime;
	private String vehicle;
	private String accommodation;
	private String diner;
	private float budget;
	private String remark;

	// Constructors

	/** default constructor */
	public Schedule() {
	}

	/** minimal constructor */
	public Schedule(Route route) {
		this.route = route;
	}

	/** full constructor */
	public Schedule(Route route, String destination, Date beginTime,
			Date endTime, String vehicle, String accommodation, String diner,
			float budget, String remark) {
		this.route = route;
		this.destination = destination;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.vehicle = vehicle;
		this.accommodation = accommodation;
		this.diner = diner;
		this.budget = budget;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "schedulingId", unique = true, nullable = false)
	public Integer getSchedulingId() {
		return this.schedulingId;
	}

	public void setSchedulingId(Integer schedulingId) {
		this.schedulingId = schedulingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "routeId", nullable = false)
	public Route getRoute() {
		return this.route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Column(name = "destination")
	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	@JSON(format="yyyy-MM-dd HH:mm")
	@Column(name = "beginTime", length = 19)
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	@JSON(format="yyyy-MM-dd HH:mm")
	@Column(name = "endTime", length = 19)
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name = "vehicle")
	public String getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	@Column(name = "accommodation")
	public String getAccommodation() {
		return this.accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	@Column(name = "diner")
	public String getDiner() {
		return this.diner;
	}

	public void setDiner(String diner) {
		this.diner = diner;
	}

	@Column(name = "budget", precision = 12, scale = 0)
	public float getBudget() {
		return this.budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Schedule [schedulingId=" + schedulingId + ", route=" + route
				+ ", destination=" + destination + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", vehicle=" + vehicle
				+ ", accommodation=" + accommodation + ", diner=" + diner
				+ ", budget=" + budget + ", remark=" + remark + "]";
	}

}