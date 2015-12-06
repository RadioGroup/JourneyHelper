package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.dao.ImageDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.ScheduleDao;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.RouteManager;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.service.impl.RouteManagerImple       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:06:26     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:06:26     
 * Modified Remark:     
 * @version   V1.0
 */
public class RouteManagerImple implements RouteManager {

	private ImageDao imageDao;
	private UserDao userDao;
	private ScheduleDao scheduleDao;
	private RouteDao routeDao;

	public ImageDao getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ScheduleDao getItineraryDao() {
		return scheduleDao;
	}

	public void setItineraryDao(ScheduleDao scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	public RouteDao getRouteDao() {
		return routeDao;
	}

	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	@Override
	public Set<Route> findUserCreateRouteList(User user) {
		Set<Route> ans = null;
		user = userDao.get(User.class, user.getUserId());
//		ans = user.getCreatelist();
//		ans.size();
		return null;
	}

	@Override
	public Set<Route> findUserJoinedRouteList(User user) {

		user = userDao.get(User.class, user.getUserId());
//		Set<Route> ans = user.getRoutelist();
//		ans.size();
		return null;
		
		
	}

	@Override
	public Integer createARoute(User user, Route route) {
		user = userDao.get(User.class, user.getUserId());
		route.setUser(user);
		Integer rid = (Integer) routeDao.save(route);

//		user.getRoutelist().add(route);

		return rid;
	}

}
