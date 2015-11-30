package com.fzu.journeyhelper.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;
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
 * A data access object (DAO) providing persistence and search support for Route
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.Route
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class RouteDAO {
	private static final Logger log = LoggerFactory.getLogger(RouteDAO.class);
	// property constants
	public static final String TITLE = "title";
	public static final String SUMMARY = "summary";
	public static final String ARTICLE = "article";

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

	public void save(Route transientInstance) {
		log.debug("saving Route instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Route persistentInstance) {
		log.debug("deleting Route instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Route findById(java.lang.Integer id) {
		log.debug("getting Route instance with id: " + id);
		try {
			Route instance = (Route) getCurrentSession().get(
					"com.fzu.journeyhelper.domain.Route", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Route> findByExample(Route instance) {
		log.debug("finding Route instance by example");
		try {
			List<Route> results = (List<Route>) getCurrentSession()
					.createCriteria("com.fzu.journeyhelper.domain.Route")
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
		log.debug("finding Route instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Route as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Route> findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List<Route> findBySummary(Object summary) {
		return findByProperty(SUMMARY, summary);
	}

	public List<Route> findByArticle(Object article) {
		return findByProperty(ARTICLE, article);
	}

	public List findAll() {
		log.debug("finding all Route instances");
		try {
			String queryString = "from Route";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Route merge(Route detachedInstance) {
		log.debug("merging Route instance");
		try {
			Route result = (Route) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Route instance) {
		log.debug("attaching dirty Route instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Route instance) {
		log.debug("attaching clean Route instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RouteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RouteDAO) ctx.getBean("RouteDAO");
	}
}