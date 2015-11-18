package com.fzu.dao;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fzu.model.Route;
import com.fzu.model.User;

public class RouteDaoHibernate extends PagingHibernateDaoSupport implements
		RouteDao {

	@Override
	public Route get(Integer id) {
		return (Route) getSessionFactory().getCurrentSession().get(Route.class,
				id);
	}

	@Override
	public Integer save(Route route) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Integer integer = (Integer) session.save(route);
		transaction.commit();
		session.close();

		return integer;
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
	public Set<Route> findRoutelistByUser(User user) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		user = (User) session.get(User.class, user.getUserId());
		Set<Route> res = user.getRoutelist();
		System.out.println(res.size());
		transaction.commit();
		session.close();
		return res;
	}

	@Override
	public Set<Route> findCreatelistByUser(User user) {
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		user = (User) session.get(User.class, user.getUserId());
		Set<Route> res = user.getCreatelist();
		System.out.println(res.size());
		transaction.commit();
		session.close();
		return res;
	}

}
