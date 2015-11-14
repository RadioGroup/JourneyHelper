package com.fzu.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PagingHibernateDaoSupport extends HibernateDaoSupport {

	/**
	 * 使用hql进行分页查询
	 * 
	 * @param hql
	 * @param offest
	 * @param pageSize
	 * @return
	 */
	public List findByPage(final String hql, final int offest,
			final int pageSize) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				List result = session.createQuery(hql).setFirstResult(offest)
						.setMaxResults(pageSize).list();
				return result;

			}

		});
		return list;

	}

	/**
	 * 
	 * @param hql
	 * @param value
	 * @param offest
	 * @param pageSize
	 * @return
	 */
	public List findByPage(final String hql, final Object value,
			final int offest, final int pageSize) {

		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				List result = session.createQuery(hql).setParameter(0, value)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}

	/**
	 * 
	 * @param hql
	 * @param value
	 * @param offest
	 * @param pageSize
	 * @return
	 */
	public List findByPage(final String hql, final Object[] value,
			final int offest, final int pageSize) {

		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				Query query = session.createQuery(hql);

				for (int i = 0; i < value.length; i++) {
					query.setParameter(i, value[i]);
				}
				List result = query.setFirstResult(offest)
						.setMaxResults(pageSize).list();
				return result;
			}
		});
		return list;
	}
}
