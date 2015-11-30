package com.fzu.journeyhelper.domain;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Notification entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.Notification
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class NotificationDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NotificationDAO.class);
	// property constants
	public static final String TYPE = "type";
	public static final String CONTENT = "content";
	public static final String ISHANDLE = "ishandle";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Notification transientInstance) {
		log.debug("saving Notification instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Notification persistentInstance) {
		log.debug("deleting Notification instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Notification findById(java.lang.Integer id) {
		log.debug("getting Notification instance with id: " + id);
		try {
			Notification instance = (Notification) getCurrentSession().get(
					"com.fzu.journeyhelper.domain.Notification", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Notification> findByExample(Notification instance) {
		log.debug("finding Notification instance by example");
		try {
			List<Notification> results = (List<Notification>) getCurrentSession()
					.createCriteria("com.fzu.journeyhelper.domain.Notification")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Notification instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Notification as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Notification> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Notification> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Notification> findByIshandle(Object ishandle) {
		return findByProperty(ISHANDLE, ishandle);
	}

	public List findAll() {
		log.debug("finding all Notification instances");
		try {
			String queryString = "from Notification";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Notification merge(Notification detachedInstance) {
		log.debug("merging Notification instance");
		try {
			Notification result = (Notification) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Notification instance) {
		log.debug("attaching dirty Notification instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Notification instance) {
		log.debug("attaching clean Notification instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static NotificationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (NotificationDAO) ctx.getBean("NotificationDAO");
	}
}