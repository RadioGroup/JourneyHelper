package com.fzu.journeyhelper.dao.impl;

import java.util.Set;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.dao.impl.RouteDaoHibernate       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:05:06     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:05:06     
 * Modified Remark:     
 * @version   V1.0
 */
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
