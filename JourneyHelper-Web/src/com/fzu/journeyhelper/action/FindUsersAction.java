package com.fzu.journeyhelper.action;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

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
