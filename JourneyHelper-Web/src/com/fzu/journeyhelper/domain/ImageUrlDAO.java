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
 * ImageUrl entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.ImageUrl
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ImageUrlDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ImageUrlDAO.class);
	// property constants
	public static final String IMAGE_URL = "imageUrl";

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

	public void save(ImageUrl transientInstance) {
		log.debug("saving ImageUrl instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ImageUrl persistentInstance) {
		log.debug("deleting ImageUrl instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ImageUrl findById(java.lang.Integer id) {
		log.debug("getting ImageUrl instance with id: " + id);
		try {
			ImageUrl instance = (ImageUrl) getCurrentSession().get(
					"com.fzu.journeyhelper.domain.ImageUrl", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<ImageUrl> findByExample(ImageUrl instance) {
		log.debug("finding ImageUrl instance by example");
		try {
			List<ImageUrl> results = (List<ImageUrl>) getCurrentSession()
					.createCriteria("com.fzu.journeyhelper.domain.ImageUrl")
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
		log.debug("finding ImageUrl instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ImageUrl as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<ImageUrl> findByImageUrl(Object imageUrl) {
		return findByProperty(IMAGE_URL, imageUrl);
	}

	public List findAll() {
		log.debug("finding all ImageUrl instances");
		try {
			String queryString = "from ImageUrl";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ImageUrl merge(ImageUrl detachedInstance) {
		log.debug("merging ImageUrl instance");
		try {
			ImageUrl result = (ImageUrl) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ImageUrl instance) {
		log.debug("attaching dirty ImageUrl instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ImageUrl instance) {
		log.debug("attaching clean ImageUrl instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ImageUrlDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ImageUrlDAO) ctx.getBean("ImageUrlDAO");
	}
}