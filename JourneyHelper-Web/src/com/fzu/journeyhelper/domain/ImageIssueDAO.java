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
 * A data access object (DAO) providing persistence and search support for
 * ImageIssue entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.ImageIssue
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ImageIssueDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ImageIssueDAO.class);
	// property constants

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

	public void save(ImageIssue transientInstance) {
		log.debug("saving ImageIssue instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ImageIssue persistentInstance) {
		log.debug("deleting ImageIssue instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ImageIssue findById(java.lang.Integer id) {
		log.debug("getting ImageIssue instance with id: " + id);
		try {
			ImageIssue instance = (ImageIssue) getCurrentSession().get(
					"com.fzu.journeyhelper.domain.ImageIssue", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ImageIssue> findByExample(ImageIssue instance) {
		log.debug("finding ImageIssue instance by example");
		try {
			List<ImageIssue> results = (List<ImageIssue>) getCurrentSession()
					.createCriteria("com.fzu.journeyhelper.domain.ImageIssue")
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
		log.debug("finding ImageIssue instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ImageIssue as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all ImageIssue instances");
		try {
			String queryString = "from ImageIssue";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ImageIssue merge(ImageIssue detachedInstance) {
		log.debug("merging ImageIssue instance");
		try {
			ImageIssue result = (ImageIssue) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ImageIssue instance) {
		log.debug("attaching dirty ImageIssue instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ImageIssue instance) {
		log.debug("attaching clean ImageIssue instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ImageIssueDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ImageIssueDAO) ctx.getBean("ImageIssueDAO");
	}
}