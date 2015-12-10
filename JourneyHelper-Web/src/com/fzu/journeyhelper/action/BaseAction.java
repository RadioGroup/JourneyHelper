package com.fzu.journeyhelper.action;

import com.fzu.journeyhelper.service.NotificationManager;
import com.fzu.journeyhelper.service.RouteManager;
import com.fzu.journeyhelper.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Copyright (C): 2015-Hoatshon Project Name: JourneyHelper-Web
 * 
 * Description: ClassName: com.fzu.journeyhelper.action.BaseAction Author:
 * Hoatson Create Time: 2015��11��20�� ����6:02:49 Modified By: Modified Time:
 * 2015��11��20�� ����6:02:49 Modified Remark:
 * 
 * @version V1.0
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected UserManager userManager;
	protected RouteManager routeManager;
	protected NotificationManager notificationManager;

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
	}

	public void setNotificationManager(NotificationManager notificationManager) {
		this.notificationManager = notificationManager;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;

	}
}
