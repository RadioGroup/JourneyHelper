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
 * RouteCommentReplay entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.RouteCommentReplay
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class RouteCommentReplayDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RouteCommentReplayDAO.class);
	// property constants
	public static final String CONTENT = "content";

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

	public void save(RouteCommentReplay transientInstance) {
		log.debug("saving RouteCommentReplay instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RouteCommentReplay persistentInstance) {
		log.debug("deleting RouteCommentReplay instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RouteCommentReplay findById(java.lang.Integer id) {
		log.debug("getting RouteCommentReplay instance with id: " + id);
		try {
			RouteCommentReplay instance = (RouteCommentReplay) getCurrentSession()
					.get("com.fzu.journeyhelper.domain.RouteCommentReplay", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<RouteCommentReplay> findByExample(RouteCommentReplay instance) {
		log.debug("finding RouteCommentReplay instance by example");
		try {
			List<RouteCommentReplay> results = (List<RouteCommentReplay>) getCurrentSession()
					.createCriteria(
							"com.fzu.journeyhelper.domain.RouteCommentReplay")
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
		log.debug("finding RouteCommentReplay instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RouteCommentReplay as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<RouteCommentReplay> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all RouteCommentReplay instances");
		try {
			String queryString = "from RouteCommentReplay";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RouteCommentReplay merge(RouteCommentReplay detachedInstance) {
		log.debug("merging RouteCommentReplay instance");
		try {
			RouteCommentReplay result = (RouteCommentReplay) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RouteCommentReplay instance) {
		log.debug("attaching dirty RouteCommentReplay instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RouteCommentReplay instance) {
		log.debug("attaching clean RouteCommentReplay instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RouteCommentReplayDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RouteCommentReplayDAO) ctx.getBean("RouteCommentReplayDAO");
	}
}