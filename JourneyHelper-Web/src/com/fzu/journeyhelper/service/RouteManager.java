package com.fzu.journeyhelper.service;

import java.util.Set;

import com.fzu.journeyhelper.domain.MyRoute;
import com.fzu.journeyhelper.domain.MyUser;

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

	public Set<MyRoute> findUserCreateRouteList(MyUser myUser);
	
	public Set<MyRoute> findUserJoinedRouteList(MyUser myUser);
	
	public Integer createARoute(MyUser myUser,MyRoute myRoute);
	
	
}
