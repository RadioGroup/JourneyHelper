package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.domain.Notification;

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
public class NotificationDaoImple extends BaseDaoHibernate4<Notification> {
	// property constants
	public static final String TYPE = "type";
	public static final String CONTENT = "content";
	public static final String ISHANDLE = "ishandle";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public List<Notification> findByType(Object type) {
		return findByProperty(Notification.class, TYPE, type);
	}

	@SuppressWarnings("unchecked")
	public List<Notification> findByContent(Object content) {
		return findByProperty(Notification.class, CONTENT, content);
	}

	@SuppressWarnings("unchecked")
	public List<Notification> findByIshandle(Object ishandle) {
		return findByProperty(Notification.class, ISHANDLE, ishandle);
	}

	public static NotificationDaoImple getFromApplicationContext(
			ApplicationContext ctx) {
		return (NotificationDaoImple) ctx.getBean("NotificationDaoImple");
	}
}