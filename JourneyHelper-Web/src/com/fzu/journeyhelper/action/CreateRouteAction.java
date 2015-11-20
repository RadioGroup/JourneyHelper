package com.fzu.journeyhelper.action;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.action.CreateRouteAction       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:03:12     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:03:12     
 * Modified Remark:     
 * @version   V1.0
 */
public class CreateRouteAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 201创建成功
	// 202创建失败
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	// 根据用户的id查询
	private Integer userId;

	// 创建行程所需要的参数
	private Integer routeId;
	private String title;
	private Date createTime;
	private Date beginTime;
	private Date endTime;
	private String property;
	private String type;
	private String strong;
	private String imageUrl;
	private String summary;
	private String content;

	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@JSON(serialize = false)
	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	@JSON(serialize = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JSON(serialize = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JSON(serialize = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JSON(serialize = false)
	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@JSON(serialize = false)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@JSON(serialize = false)
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	@JSON(serialize = false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JSON(serialize = false)
	public String getStrong() {
		return strong;
	}

	public void setStrong(String strong) {
		this.strong = strong;
	}

	@JSON(serialize = false)
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageurl) {
		this.imageUrl = imageurl;
	}

	@JSON(serialize = false)
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@JSON(serialize = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String createRoute() throws Exception {

		User user = new User();
		user.setUserId(getUserId());

		route = new Route();
		Date date = new Date();
		setCreateTime(date);
		route.setCreateTime(date);
		route.setTitle(getTitle());
		route.setBeginTime(getBeginTime());
		route.setEndTime(getEndTime());
		route.setProperty(getProperty());
		route.setType(getType());
		route.setStrong(getStrong());
		route.setImageUrl(getImageUrl());
		route.setSummary(getSummary());
		route.setContent(content);

		Integer id = routeManager.createARoute(user, route);
		route.setRouteId(id);
		System.out.println(id);

		setStatus(201);
		return SUCCESS;
	}

}
