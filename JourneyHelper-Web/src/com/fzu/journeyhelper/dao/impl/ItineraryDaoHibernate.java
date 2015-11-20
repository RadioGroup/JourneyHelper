package com.fzu.journeyhelper.dao.impl;

import java.util.List;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.ItineraryDao;
import com.fzu.journeyhelper.domain.Itinerary;
import com.fzu.journeyhelper.domain.Route;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.dao.impl.ItineraryDaoHibernate       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:04:59     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:04:59     
 * Modified Remark:     
 * @version   V1.0
 */
public class ItineraryDaoHibernate extends BaseDaoHibernate4<Itinerary>
		implements ItineraryDao {

	@Override
	public List<Itinerary> findByRoute(Route route) {
		// TODO 增加查询行程的规划
		return null;
	}

}
