package com.fzu.journeyhelper.action;

import org.apache.struts2.json.annotations.JSON;

import com.fzu.journeyhelper.service.RouteManager;
import com.fzu.journeyhelper.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.action.BaseAction       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:02:49     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:02:49     
 * Modified Remark:     
 * @version   V1.0
 */
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
