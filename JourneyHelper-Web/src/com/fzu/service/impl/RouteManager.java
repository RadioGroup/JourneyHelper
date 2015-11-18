package com.fzu.service.impl;

import java.util.Set;

import com.fzu.model.Route;
import com.fzu.model.User;

public interface RouteManager {

	public Set<Route> findUserCreateRouteList(User user);
	
	public Set<Route> findUserParticipatorRouteList(User user);
	
	public Integer createARoute(Route route);
	
	
}
