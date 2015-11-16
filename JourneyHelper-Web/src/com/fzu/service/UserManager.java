package com.fzu.service;

import com.fzu.dao.ImageDao;
import com.fzu.dao.ItineraryDao;
import com.fzu.dao.RouteDao;
import com.fzu.dao.UserDao;
import com.fzu.model.User;

public class UserManager implements Authentication {

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
		// TODO Auto-generated method stub
		return userDao.findbyUserNameAndPass(user);
	}
}
