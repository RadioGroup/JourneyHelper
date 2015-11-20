package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.dao.ImageDao;
import com.fzu.journeyhelper.dao.ItineraryDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.RouteManager;

public class RouteManagerImple implements RouteManager {

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
	public Set<Route> findUserCreateRouteList(User user) {
		Set<Route> ans = null;
		user = userDao.get(User.class, user.getUserId());
		ans = user.getCreatelist();
		ans.size();
		return ans;
	}

	@Override
	public Set<Route> findUserJoinedRouteList(User user) {

		user = userDao.get(User.class, user.getUserId());
		Set<Route> ans = user.getRoutelist();
		ans.size();
		return ans;
		
		
	}

	@Override
	public Integer createARoute(User user, Route route) {
		user = userDao.get(User.class, user.getUserId());
		route.setCreateUser(user);
		Integer rid = (Integer) routeDao.save(route);

		user.getRoutelist().add(route);

		return rid;
	}

}
