package com.fzu.journeyhelper.action.routeaction;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.impl.RouteManager;
import com.fzu.journeyhelper.service.impl.UserManager;
import com.opensymphony.xwork2.Action;

import java.util.Date;

public class CreateRouteAction implements Action {

	// 201创建成功
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
	private String imageurl;
	private String summary;
	private String content;

	private Route route;
	private User user;
	
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStrong() {
		return strong;
	}

	public void setStrong(String strong) {
		this.strong = strong;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	private UserManager userManager;
	private RouteManager routeManager;

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public RouteManager getRouteManager() {
		return routeManager;
	}

	public void setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
	}

	public String createRoute() throws Exception {

		user=new User();
		user.setUserId(getUserId());

		route = new Route();
		Date date = new Date();
		setCreateTime(date);
		route.setCreateTime(date);
		route.setTitle(getTitle());
		route.setBeginTime(getBeginTime());
		route.setEndTime(getEndTime());
		route.setProperty(getProperty());
		route.setCreateUser(user);
		route.setType(getType());
		route.setStrong(getStrong());
		route.setImageUrl(getImageurl());
		route.setSummary(getSummary());
		route.setContent(content);

		
		
		Integer id = routeManager.createARoute(user,route);
		route.setRouteId(id);
		setRouteId(id);
		System.out.println(id);

		return SUCCESS;
	}

}
