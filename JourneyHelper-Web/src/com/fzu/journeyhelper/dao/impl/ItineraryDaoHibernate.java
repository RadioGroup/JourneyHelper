package com.fzu.journeyhelper.dao.impl;

import java.util.List;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.ItineraryDao;
import com.fzu.journeyhelper.domain.Itinerary;
import com.fzu.journeyhelper.domain.Route;

public class ItineraryDaoHibernate extends BaseDaoHibernate4<Itinerary>
		implements ItineraryDao {

	@Override
	public List<Itinerary> findByRoute(Route route) {
		// TODO 增加查询行程的规划
		return null;
	}

}
