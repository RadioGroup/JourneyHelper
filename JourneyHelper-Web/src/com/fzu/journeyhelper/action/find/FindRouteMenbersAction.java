package com.fzu.journeyhelper.action.find;

import java.util.Set;

import com.fzu.journeyhelper.action.BaseAction;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;


/**
 * 获取团队成员列表
 * @author Volcano
 *
 */
public class FindRouteMenbersAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

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

	public void setUsers(Set<User> Users) {
		this.users = Users;
	}

	public String findRouteMenberList() throws Exception {
		Route Route = new Route();
		Route.setRouteId(getRouteId());
		status = 201;
		users = userManager.findRouteMenbers(Route);
		if(users==null){
			status = 202;//routeId不存在
			return ERROR;
		}
		return SUCCESS;
	}
	
}
