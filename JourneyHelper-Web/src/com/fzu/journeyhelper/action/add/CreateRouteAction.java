package com.fzu.journeyhelper.action.add;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.fzu.journeyhelper.action.BaseAction;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 行程创建action
 * 
 * @author Volcano
 * 
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

	// 创建者id
	private Integer userId;

	// 创建行程需要的参数
	private String title;
	private Date beginTime;// 集合时间
	private Date endTime;
	private String summary;
	private String article;
	private String routeImageUrl;// 标志图片
	private Integer type;// 行程类型101个人,102AA,103跟团
	private String secnics;// 景点，各个景点已分号隔开，如吉林雾凇岛;东北雪乡;东升雪谷;
	private String assemblingPlace;// 集合地点
	private String strengthGrade;// 强度等级，如滑雪;休闲;登山;徒步;摄影;骑马;露营;自驾

	private Route route;
	private User user;

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

	@JSON(serialize = false)
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@JSON(serialize = false)
	public String getRouteImageUrl() {
		return routeImageUrl;
	}

	public void setRouteImageUrl(String routeImageUrl) {
		this.routeImageUrl = routeImageUrl;
	}

	@JSON(serialize = false)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@JSON(serialize = false)
	public String getSecnics() {
		return secnics;
	}

	public void setSecnics(String secnics) {
		this.secnics = secnics;
	}

	@JSON(serialize = false)
	public String getAssemblingPlace() {
		return assemblingPlace;
	}

	public void setAssemblingPlace(String assemblingPlace) {
		this.assemblingPlace = assemblingPlace;
	}

	@JSON(serialize = false)
	public String getStrengthGrade() {
		return strengthGrade;
	}

	public void setStrengthGrade(String strengthGrade) {
		this.strengthGrade = strengthGrade;
	}

	public Route getRoute() {
		return route;
	}

	@JSON(serialize = false)
	public User getUser() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	public String createRoute() throws Exception {

		User user = new User();
		user.setUserId(getUserId());

		route = new Route();
		route.setTitle(title);
		route.setBeginTime(beginTime);
		route.setEndTime(endTime);
		route.setSummary(summary);
		route.setArticle(article);
		route.setRouteImageUrl(routeImageUrl);
		route.setType(type);
		route.setSecnics(secnics);
		route.setAssemblingPlace(assemblingPlace);
		route.setStrengthGrade(strengthGrade);
		
		
		Integer id = routeManager.createARoute(user, route);
		//route.setRouteId(id);
		System.out.println(id);

		setStatus(201);
		return SUCCESS;
	}

}
