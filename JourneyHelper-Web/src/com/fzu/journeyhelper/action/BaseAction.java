package com.fzu.journeyhelper.action;

import org.apache.struts2.json.annotations.JSON;

import com.fzu.journeyhelper.service.RouteManager;
import com.fzu.journeyhelper.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UserManager userManager;
	protected RouteManager routeManager;

	@JSON(serialize = false)
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@JSON(serialize = false)
	public RouteManager getRouteManager() {
		return routeManager;
	}

	public void setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
	}
	
	
}
