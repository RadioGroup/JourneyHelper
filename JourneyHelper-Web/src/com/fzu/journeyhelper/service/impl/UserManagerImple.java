package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.dao.ImageDao;
import com.fzu.journeyhelper.dao.ItineraryDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.UserManager;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.service.impl.UserManagerImple       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:06:33     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:06:33     
 * Modified Remark:     
 * @version   V1.0
 */
public class UserManagerImple implements UserManager {

	private ImageDao imageDao;
	private UserDao userDao;
	private ItineraryDao itineraryDao;
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

	public ItineraryDao getItineraryDao() {
		return itineraryDao;
	}

	public void setItineraryDao(ItineraryDao itineraryDao) {
		this.itineraryDao = itineraryDao;
	}

	public RouteDao getRouteDao() {
		return routeDao;
	}

	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	@Override
	public User loginAuthen(User user) {
		return userDao.findbyUserNameAndPass(user);
	}

	@Override
	public Integer registNewUser(User user) {
		return (Integer) userDao.save(user);
	}

	@Override
	public boolean registAvaliable(User user) {
		return !userDao.isExistByUserName(user);
	}

	@Override
	public Set<User> findUsersList(Route route) {
		route = routeDao.get(Route.class, route.getRouteId());
		Set<User> res = route.getUsers();
		res.size();
		return res;
	}

}
