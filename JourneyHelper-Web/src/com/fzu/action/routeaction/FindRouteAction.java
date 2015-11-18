package com.fzu.action.routeaction;

import java.util.Set;

import com.fzu.model.Route;
import com.fzu.model.User;
import com.fzu.service.impl.RouteManager;
import com.fzu.service.impl.UserManager;
import com.opensymphony.xwork2.Action;

public class FindRouteAction implements Action {

	// 根据用户的id查询
	private Integer userId;

	// 根据用户名查询
	private String userName;

	private UserManager userManager;
	private RouteManager routeManager;

	private Set<Route> createList;
	private Set<Route> joindeList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public Set<Route> getCreateList() {
		return createList;
	}

	public void setCreateList(Set<Route> createList) {
		this.createList = createList;
	}

	public Set<Route> getJoindeList() {
		return joindeList;
	}

	public void setJoindeList(Set<Route> joindeList) {
		this.joindeList = joindeList;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String findCreateRouteList() throws Exception {

		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		createList = routeManager.findUserCreateRouteList(user);
		return SUCCESS;
	}

	public String findJoingRouteList() throws Exception {
		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		joindeList = routeManager.findUserParticipatorRouteList(user);
		return SUCCESS;
	}

}
