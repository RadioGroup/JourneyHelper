package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.NotificationDao;
import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.User;

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
public class NotificationDaoImple extends BaseDaoHibernate4<Notification>
		implements NotificationDao {
	// property constants
	public static final String TYPE = "type";
	public static final String CONTENT = "content";
	public static final String ISHANDLE = "ishandle";

	public NotificationDaoImple() {

	}

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

	@Override
	public Set<Notification> findUserNotifications(User user, short isHandle) {
		Set<Notification> list = new HashSet<Notification>();
		// TODO list向set的转化是否多余？等待优化探究 
		list.addAll(find(
				"from Notification as n where n.userByReceiveUserId=?0 and n.ishandle=?1",
				user, isHandle));
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}

	}

	@Override
	public Set<Notification> findUserNotificationByType(User uesr, Short type) {
		// TODO 查询不同类型的通知，如申请，或者行程更新
		return null;
	}
}