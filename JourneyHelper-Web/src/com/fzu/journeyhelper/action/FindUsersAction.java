package com.fzu.journeyhelper.action;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;


/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.action.FindUsersAction       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:03:36     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:03:36     
 * Modified Remark:     
 * @version   V1.0
 */
public class FindUsersAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer routeId;
	private Set<User> users;

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public String findUsersList() throws Exception {
		Route route = new Route();
		route.setRouteId(getRouteId());

		users = userManager.findUsersList(route);
		return SUCCESS;
	}

}
