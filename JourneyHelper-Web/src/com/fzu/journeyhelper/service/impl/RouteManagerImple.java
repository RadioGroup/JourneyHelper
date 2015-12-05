package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.dao.ImageIssueDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.ScheduleDao;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.RouteManager;

/**
 * 
 * @author Volcano
 * 
 */
public class RouteManagerImple implements RouteManager {

	private ImageIssueDao imageIssueDao;
	private UserDao userDao;
	private ScheduleDao scheduleDao;
	private RouteDao routeDao;

	public ImageIssueDao getImageIssueDao() {
		return imageIssueDao;
	}

	public void setImageIssueDao(ImageIssueDao imageIssueDao) {
		this.imageIssueDao = imageIssueDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ScheduleDao getScheduleDao() {
		return scheduleDao;
	}

	public void setScheduleDao(ScheduleDao scheduleDao) {
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
		ans = user.getCreateRoutes();
		// ans.size();
		return ans;
	}

	@Override
	public Set<Route> findUserJoinedRouteList(User user) {

		user = userDao.get(User.class, user.getUserId());
		// Set<Route> ans = user.getRoutelist();
		// ans.size();
		return null;

	}

	@Override
	public Set<Route> findUserAllRouteList(User user) {

		user = userDao.get(User.class, user.getUserId());
		// Set<Route> ans = user.getRoutelist();
		// ans.size();
		return null;

	}
	
	@Override
	public Integer createARoute(User user, Route route) {
		user = userDao.get(User.class, user.getUserId());
		route.setUser(user);
		Integer rid = (Integer) routeDao.save(route);

		// user.getRoutelist().add(route);

		return rid;
	}

}
