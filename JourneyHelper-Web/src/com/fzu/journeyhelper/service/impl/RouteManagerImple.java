package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.RouteManager;

/**
 * 
 * @author Volcano
 * 
 */
public class RouteManagerImple extends BaseManager implements RouteManager {

	@Override
	public Set<Route> findUserCreateRouteList(User user) {
		Set<Route> ans = null;
		user = userDao.get(User.class, user.getUserId());
		ans = user.getCreateRoutes();
		ans.size();
		return ans;
	}

	@Override
	public Set<Route> findUserJoinedRouteList(User user) {

		user = userDao.get(User.class, user.getUserId());
		Set<Route> ans = user.getJoinRoutes();
		ans.size();
		return ans;

	}

	@Override
	public Set<Route> findUserAllRouteList(User user) {
		return findUserJoinedRouteList(user);
	}

	@Override
	public Integer createARoute(User user, Route route) {
		user = userDao.get(User.class, user.getUserId());
		route.setUser(user);
		Integer rid = (Integer) routeDao.save(route);
		user.getJoinRoutes().add(route);

		return rid;
	}

}
