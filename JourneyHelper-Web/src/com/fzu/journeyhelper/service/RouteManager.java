package com.fzu.journeyhelper.service;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.service.RouteManager       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:06:10     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:06:10     
 * Modified Remark:     
 * @version   V1.0
 */
public interface RouteManager {

	public Set<Route> findUserCreateRouteList(User user);
	
	public Set<Route> findUserJoinedRouteList(User user);
	
	public Integer createARoute(User user,Route route);
	
	
}
