package com.fzu.dao;

import java.util.List;

import com.fzu.model.Route;
import com.fzu.model.User;

public class UserDaoHibernate extends PagingHibernateDaoSupport implements
		UserDao {

	@Override
	public User get(Integer id) {
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public Integer save(User user) {
		return (Integer) getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<User> findByRoute(Route route) {
		// TODO N-N连接查询，待解决
		return null;
//				(List<User>) getHibernateTemplate().find(
//				"from User as u where u.route=?", route);
	}

}
