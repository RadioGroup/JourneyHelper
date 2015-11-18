package com.fzu.service;

import java.util.List;
import java.util.Set;

import com.fzu.dao.ImageDao;
import com.fzu.dao.ItineraryDao;
import com.fzu.dao.RouteDao;
import com.fzu.dao.UserDao;
import com.fzu.model.Route;
import com.fzu.model.User;
import com.fzu.service.impl.RouteManager;

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

		ans = routeDao.findCreatelistByUser(user);

		return ans;
	}

	@Override
	public Set<Route> findUserParticipatorRouteList(User user) {
		Set<Route> ans = null;
		ans = routeDao.findCreatelistByUser(user);

		return ans;
	}

	@Override
	public Integer createARoute(User user,Route route) {
		user = userDao.get(user.getUserId());
		user.getCreatelist().add(route);
		user.getRoutelist().add(route);
		
		route.getTeamrecod().add(user);
		
		Integer integer = routeDao.save(route);
		userDao.update(user);
		return integer;
	}

}
