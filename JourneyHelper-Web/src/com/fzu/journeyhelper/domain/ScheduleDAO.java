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
 * Schedule entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.Schedule
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ScheduleDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ScheduleDAO.class);
	// property constants
	public static final String DESTINATION = "destination";
	public static final String VEHICLE = "vehicle";
	public static final String ACCOMMODATION = "accommodation";
	public static final String DINER = "diner";
	public static final String BUDGET = "budget";
	public static final String REMARK = "remark";

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

	public void save(Schedule transientInstance) {
		log.debug("saving Schedule instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Schedule persistentInstance) {
		log.debug("deleting Schedule instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Schedule findById(java.lang.Integer id) {
		log.debug("getting Schedule instance with id: " + id);
		try {
			Schedule instance = (Schedule) getCurrentSession().get(
					"com.fzu.journeyhelper.domain.Schedule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Schedule> findByExample(Schedule instance) {
		log.debug("finding Schedule instance by example");
		try {
			List<Schedule> results = (List<Schedule>) getCurrentSession()
					.createCriteria("com.fzu.journeyhelper.domain.Schedule")
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
		log.debug("finding Schedule instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Schedule as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Schedule> findByDestination(Object destination) {
		return findByProperty(DESTINATION, destination);
	}

	public List<Schedule> findByVehicle(Object vehicle) {
		return findByProperty(VEHICLE, vehicle);
	}

	public List<Schedule> findByAccommodation(Object accommodation) {
		return findByProperty(ACCOMMODATION, accommodation);
	}

	public List<Schedule> findByDiner(Object diner) {
		return findByProperty(DINER, diner);
	}

	public List<Schedule> findByBudget(Object budget) {
		return findByProperty(BUDGET, budget);
	}

	public List<Schedule> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all Schedule instances");
		try {
			String queryString = "from Schedule";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Schedule merge(Schedule detachedInstance) {
		log.debug("merging Schedule instance");
		try {
			Schedule result = (Schedule) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Schedule instance) {
		log.debug("attaching dirty Schedule instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Schedule instance) {
		log.debug("attaching clean Schedule instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ScheduleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ScheduleDAO) ctx.getBean("ScheduleDAO");
	}
}