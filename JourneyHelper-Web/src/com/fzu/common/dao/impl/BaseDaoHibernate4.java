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

	// DAO组件进行持久化操作底层依赖的SessionFactory组件
	private SessionFactory sessionFactory;

	// 依赖注入SessionFactory所需的setter方法
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// 根据ID加载实体
	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getCurrentSession().get(entityClazz, id);
	}

	// 保存实体
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

	// 更新实体
	public void update(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	// 删除实体
	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	// 根据ID删除实体
	public void delete(Class<T> entityClazz, Serializable id) {
		getCurrentSession()
				.createQuery(
						"delete " + entityClazz.getSimpleName()
								+ " en where en.id = ?0").setParameter("0", id)
				.executeUpdate();
	}

	// 获取实体总数
	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		// 返回查询得到的实体总数
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	// 根据HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return (List<T>) getCurrentSession().createQuery(hql).list();
	}

	// 根据带占位符参数HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		// 创建查询
		Query query = getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}

	// 获取所有实体
	public List<T> findAll(Class<T> entityClazz) {

		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		// 创建查询
		return getCurrentSession().createQuery(hql)
				// 执行分页
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	/**
	 * 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * @param params
	 *            如果hql带占位符参数，params用于传入占位符参数
	 * @param pageNo
	 *            查询第pageNo页的记录
	 * @param pageSize
	 *            每页需要显示的记录数
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize,
			Object... params) {
		// 创建查询
		Query query = getCurrentSession().createQuery(hql);
		// 为包含占位符的HQL语句设置参数
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize).list();
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(Class<T> entityClazz, String propertyName,
			Object value) {
		try {
			String queryString = "from " + entityClazz.getSimpleName()
					+ " as model where model." + propertyName + "= ?";
			return find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
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
