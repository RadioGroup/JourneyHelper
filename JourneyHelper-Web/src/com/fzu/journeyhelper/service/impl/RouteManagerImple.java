package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.dao.ImageDao;
import com.fzu.journeyhelper.dao.ItineraryDao;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.MyRoute;
import com.fzu.journeyhelper.domain.MyUser;
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
	public Set<MyRoute> findUserCreateRouteList(MyUser myUser) {
		Set<MyRoute> ans = null;
		myUser = userDao.get(MyUser.class, myUser.getUserId());
		ans = myUser.getCreatelist();
		ans.size();
		return ans;
	}

	@Override
	public Set<MyRoute> findUserJoinedRouteList(MyUser myUser) {

		myUser = userDao.get(MyUser.class, myUser.getUserId());
		Set<MyRoute> ans = myUser.getRoutelist();
		ans.size();
		return ans;
		
		
	}

	@Override
	public Integer createARoute(MyUser myUser, MyRoute myRoute) {
		myUser = userDao.get(MyUser.class, myUser.getUserId());
		myRoute.setCreateUser(myUser);
		Integer rid = (Integer) routeDao.save(myRoute);

		myUser.getRoutelist().add(myRoute);

		return rid;
	}

}
