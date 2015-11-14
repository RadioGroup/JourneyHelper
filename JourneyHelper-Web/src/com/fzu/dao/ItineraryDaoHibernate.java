package com.fzu.dao;

import java.util.List;

import com.fzu.model.Itinerary;
import com.fzu.model.Route;

public class ItineraryDaoHibernate extends PagingHibernateDaoSupport implements ItineraryDao{

	@Override
	public Itinerary get(Integer id) {
		return getHibernateTemplate().get(Itinerary.class, id);
	}

	@Override
	public Integer save(Itinerary itinerary) {
		return (Integer) getHibernateTemplate().save(itinerary);
	}

	@Override
	public void update(Itinerary itinerary) {
		getHibernateTemplate().update(itinerary);
	}

	@Override
	public void delete(Itinerary itinerary) {
		getHibernateTemplate().delete(itinerary);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Itinerary> findByRoute(Route route) {
		// TODO 增加查询行程的规划
		return null;
	}

}
