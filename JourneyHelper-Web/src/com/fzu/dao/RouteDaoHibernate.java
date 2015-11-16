package com.fzu.dao;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import com.fzu.model.Route;
import com.fzu.model.User;

public class RouteDaoHibernate extends PagingHibernateDaoSupport implements
		RouteDao {

	
	@Override
	public Route get(Integer id) {
		return (Route) getSessionFactory().getCurrentSession().get(Route.class, id);
	}

	@Override
	public Integer save(Route route) {
		return (Integer) getSessionFactory().getCurrentSession().save(route);
	}

	@Override
	public void update(Route route) {
		getSessionFactory().getCurrentSession().update(route);
	}

	@Override
	public void delete(Route route) {
		getSessionFactory().getCurrentSession().delete(route);
	}

	@Override
	public void delete(Integer id) {
		getSessionFactory().getCurrentSession().delete(get(id));
	}

	@Override
	public List<Route> findUserlistByUser(User user) {

		return null;
	}

	@Override
	public List<Route> findCreatelistByUser(User user) {
		return null;
	}

}
