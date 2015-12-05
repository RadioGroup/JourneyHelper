package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.dao.ImageIssueDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.ScheduleDao;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.UserManager;

/**
 * 
 * @author Volcano
 *
 */
public class UserManagerImple implements UserManager {

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
	public User loginAuthen(User User) {
		return userDao.findbyUserNameAndPass(User);
	}

	@Override
	public Integer registNewUser(User User) {
		return (Integer) userDao.save(User);
	}

	@Override
	public boolean registAvaliable(User User) {
		return !userDao.isExistByUserName(User);
	}

	@Override
	public Set<User> findUsersList(Route route) {
		route = routeDao.get(Route.class, route.getRouteId());
		// Set<User> res = myRoute.getUsers();
		// res.size();
		// return res;
		return null;
	}

}
