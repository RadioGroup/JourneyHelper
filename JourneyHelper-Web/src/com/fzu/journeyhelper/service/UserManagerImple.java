package com.fzu.journeyhelper.service;

import com.fzu.journeyhelper.dao.ImageDao;
import com.fzu.journeyhelper.dao.ItineraryDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.impl.UserManager;

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
		return userDao.save(user);
	}

	
	@Override
	public boolean registAvaliable(User user) {
		return !userDao.isExistByUserName(user);
	}
	
	
}
