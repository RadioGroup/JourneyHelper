package com.fzu.journeyhelper.service.impl;

import com.fzu.journeyhelper.dao.ImageIssueDao;
import com.fzu.journeyhelper.dao.NotificationDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.ScheduleDao;
import com.fzu.journeyhelper.dao.UserDao;

public class BaseManager {

	protected ImageIssueDao imageIssueDao;
	protected UserDao userDao;
	protected ScheduleDao scheduleDao;
	protected RouteDao routeDao;
	protected NotificationDao notificationDao;

	public void setImageIssueDao(ImageIssueDao imageIssueDao) {
		this.imageIssueDao = imageIssueDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	public void setNotificationDao(NotificationDao notificationDao) {
		this.notificationDao = notificationDao;
	}

	public ImageIssueDao getImageIssueDao() {
		return imageIssueDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public RouteDao getRouteDao() {
		return routeDao;
	}

	public NotificationDao getNotificationDao() {
		return notificationDao;
	}

}
