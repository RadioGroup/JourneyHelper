package com.fzu.dao;

import java.util.List;

import com.fzu.model.Route;
import com.fzu.model.User;

public class RouteDaoHibernate extends PagingHibernateDaoSupport implements
		RouteDao {

	@Override
	public Route get(Integer id) {
		return getHibernateTemplate().get(Route.class, id);
	}

	@Override
	public Integer save(Route route) {
		return (Integer) getHibernateTemplate().save(route);
	}

	@Override
	public void update(Route route) {
		getHibernateTemplate().update(route);
	}

	@Override
	public void delete(Route route) {
		getHibernateTemplate().delete(route);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Route> findUserlistByUser(User user) {

		return null;
	}

	@Override
	public List<Route> findCreatelistByUser(User user) {
		return (List<Route>) getHibernateTemplate().find(
				"from Route as r where r.createUser=?", user);
	}

}
