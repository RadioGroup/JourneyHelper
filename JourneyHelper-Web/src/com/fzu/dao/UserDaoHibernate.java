package com.fzu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fzu.model.Route;
import com.fzu.model.User;
import com.sun.mail.util.QEncoderStream;

public class UserDaoHibernate extends PagingHibernateDaoSupport implements
		UserDao {

	@Override
	public User get(Integer id) {

		return (User) getSessionFactory().getCurrentSession().get(User.class,
				id);
	}

	@Override
	public Integer save(User user) {
		return (Integer) getSessionFactory().getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	@Override
	public void delete(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	@Override
	public void delete(Integer id) {
		getSessionFactory().getCurrentSession().delete(get(id));
	}

	@Override
	public List<User> findByRoute(Route route) {
		// TODO N-N连接查询，待解决
		return null;
		// (List<User>) getHibernateTemplate().find(
		// "from User as u where u.route=?", route);
	}

	@Override
	public User findbyUserNameAndPass(User user) {

		System.out.println(user.toString());
		Session session = getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery(
						"from User as u where u.userName=:username and u.passWord=:password")
				.setString("username", user.getUserName())
				.setString("password", user.getPassWord());
		List<User> list = (List<User>) query.list();
		session.close();

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

}
