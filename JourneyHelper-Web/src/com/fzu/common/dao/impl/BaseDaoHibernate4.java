package com.fzu.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fzu.common.dao.BaseDao;

public class BaseDaoHibernate4<T> implements BaseDao<T> {

	protected static final Logger log = LoggerFactory
			.getLogger(BaseDaoHibernate4.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean isExist(Class<T> entityClazz, Serializable id) {
		// TODO 写一个判断是否存在的方法
		return false;
	}

	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getCurrentSession().get(entityClazz, id);
	}

	public Serializable save(T entity) {
		log.debug("saving User instance");
		try {
			getCurrentSession().save(entity);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}

		return getCurrentSession().save(entity);
	}

	public void update(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void delete(Class<T> entityClazz, Serializable id) {
		getCurrentSession()
				.createQuery(
						"delete " + entityClazz.getSimpleName()
								+ " en where en.id = ?0").setParameter("0", id)
				.executeUpdate();
	}

	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return (List<T>) getCurrentSession().createQuery(hql).list();
	}

	// 带有参数的hql查询
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		System.out.println("enter");
		Query query = getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		System.out.println("queryString = ");
		System.out.println(query.getQueryString());

		return null;
		// (List<T>) query.list();
	}

	// 带有参数的sql查询
	@SuppressWarnings("unchecked")
	protected List<T> findBySql(String sql, Object... params) {
		System.out.println("enter");
		Query query = getCurrentSession().createSQLQuery(sql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		System.out.println("queryString = ");
		System.out.println(query.getQueryString());

		return (List<T>) query.list();
	}

	// 查询所有
	public List<T> findAll(Class<T> entityClazz) {

		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	/**
	 * 分页查询
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPage(String hql, int pageNo, int pageSize) {
		return getCurrentSession().createQuery(hql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	/**
	 * hql 分页查询
	 * 
	 * @param hql
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPage(String hql, int pageNo, int pageSize,
			Object... params) {
		Query query = getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(Class<T> entityClazz, String propertyName,
			Object value) {
		try {
			String queryString = "from " + entityClazz.getSimpleName()
					+ " as model where model." + propertyName + "= ?0";
			return find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	
	/**
	 * 分页查询
	 * 
	 * @param sql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPageSQL(String sql, int pageNo, int pageSize) {
		return getCurrentSession().createSQLQuery(sql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	/**
	 * sql 分页查询
	 * 
	 * @param hql
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPageSQL(String sql, int pageNo, int pageSize,
			Object... params) {
		Query query = getCurrentSession().createSQLQuery(sql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}
	
	
	

	@SuppressWarnings("unchecked")
	public T merge(Class<T> detachedInstance) {
		log.debug("attaching merge " + detachedInstance.getSimpleName()
				+ " instance");
		try {
			T result = (T) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Class<T> instance) {
		log.debug("attaching dirty " + instance.getSimpleName() + " instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Class<T> instance) {
		log.debug("attaching clean " + instance.getSimpleName() + " instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

}
