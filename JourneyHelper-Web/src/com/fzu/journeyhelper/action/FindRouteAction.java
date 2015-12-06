package com.fzu.journeyhelper.action;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon Project Name: JourneyHelper-Web
 * 
 * Description: ClassName: com.fzu.journeyhelper.action.FindRouteAction Author:
 * Hoatson Create Time: 2015年11月20日 下午6:03:18 Modified By: Modified Time:
 * 2015年11月20日 下午6:03:18 Modified Remark:
 * 
 * @version V1.0
 */
public class FindRouteAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 根据用户的id查询
	private Integer userId;

	// 根据用户名查询
	private String userName;

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

	private Set<Route> createList;
	private Set<Route> joindeList;

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
		joindeList = routeManager.findUserJoinedRouteList(user);
		return SUCCESS;
	}

}
