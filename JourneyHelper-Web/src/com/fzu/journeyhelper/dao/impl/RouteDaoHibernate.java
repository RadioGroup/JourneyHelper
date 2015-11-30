package com.fzu.journeyhelper.dao.impl;

import java.util.Set;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.domain.MyRoute;
import com.fzu.journeyhelper.domain.MyUser;

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
public class RouteDaoHibernate extends BaseDaoHibernate4<MyRoute> implements
		RouteDao {

	@Override
	public Set<MyRoute> findRoutelistByUser(MyUser myUser) {
		return null;
	}

	@Override
	public Set<MyRoute> findCreatelistByUser(MyUser myUser) {
		return null;
	}

}
