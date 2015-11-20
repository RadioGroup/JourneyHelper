package com.fzu.journeyhelper.dao.impl;

import java.util.Set;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public class RouteDaoHibernate extends BaseDaoHibernate4<Route> implements
		RouteDao {

	@Override
	public Set<Route> findRoutelistByUser(User user) {
		return null;
	}

	@Override
	public Set<Route> findCreatelistByUser(User user) {
		return null;
	}

}
