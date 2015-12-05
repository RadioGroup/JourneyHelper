package com.fzu.journeyhelper.action;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * @author Volcano
 *
 */
public class FindRouteAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	// 通过用户名或者id获得用户的行程表
	private Integer userId;
	private String userName;

	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

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
	private Set<Route> allList;
	
	
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

	public Set<Route> getAllList() {
		return allList;
	}

	public void setAllList(Set<Route> allList) {
		this.allList = allList;
	}
	
	@Override
	public String execute() throws Exception {
		return null;
	}

	public String findCreateRoutes() throws Exception {
		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		createList = routeManager.findUserCreateRouteList(user);
		System.out.println(createList.size());
		setStatus(301);
		return SUCCESS;
	}

	public String findJoingRoutes() throws Exception {
		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		joindeList = routeManager.findUserJoinedRouteList(user);
		setStatus(301);
		return SUCCESS;
	}

	public String findallRoutes() throws Exception{
		
		User user = new User();
		user.setUserId(getUserId());
		user.setUserName(userName);
		createList = routeManager.findUserCreateRouteList(user);
		return SUCCESS;
	}
	
}
