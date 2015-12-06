package com.fzu.journeyhelper.action;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon Project Name: JourneyHelper-Web
 * 
 * Description: ClassName: com.fzu.journeyhelper.action.CreateRouteAction
 * Author: Hoatson Create Time: 2015年11月20日 下午6:03:12 Modified By: Modified
 * Time: 2015年11月20日 下午6:03:12 Modified Remark:
 * 
 * @version V1.0
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
	private String title;
	private String summary;
	private String article;
	private Date beginTime;
	private Date endTime;
//	private String property;
//	private String type;
//	private String strong;
//	private String imageUrl;
//	private String content;

	private Route route;

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
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
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String createRoute() throws Exception {

		User user = new User();
		user.setUserId(getUserId());

		route = new Route();
		route.setTitle(getTitle());
		route.setBeginTime(getBeginTime());
		route.setEndTime(getEndTime());
		route.setSummary(getSummary());
		route.setArticle(getArticle());;

		Integer id = routeManager.createARoute(user, route);
		route.setRouteId(id);
		System.out.println(id);
		
		setStatus(201);
		return SUCCESS;
	}

}
