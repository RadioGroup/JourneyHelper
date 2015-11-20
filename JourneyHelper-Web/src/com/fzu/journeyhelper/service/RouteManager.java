package com.fzu.journeyhelper.service;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public interface RouteManager {

	public Set<Route> findUserCreateRouteList(User user);
	
	public Set<Route> findUserJoinedRouteList(User user);
	
	public Integer createARoute(User user,Route route);
	
	
}
