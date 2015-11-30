package com.fzu.journeyhelper.action;

import java.util.Set;

import com.fzu.journeyhelper.domain.MyRoute;
import com.fzu.journeyhelper.domain.MyUser;


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
	private Set<MyUser> myUsers;

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Set<MyUser> getUsers() {
		return myUsers;
	}

	public void setUsers(Set<MyUser> myUsers) {
		this.myUsers = myUsers;
	}

	public String findUsersList() throws Exception {
		MyRoute myRoute = new MyRoute();
		myRoute.setRouteId(getRouteId());

		myUsers = userManager.findUsersList(myRoute);
		return SUCCESS;
	}

}
