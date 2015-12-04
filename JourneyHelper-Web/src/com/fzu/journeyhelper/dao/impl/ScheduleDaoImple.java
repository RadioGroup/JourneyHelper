package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.ScheduleDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.Schedule;

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
public class ScheduleDaoImple extends BaseDaoHibernate4<Schedule> implements
		ScheduleDao {

	// property constants
	public static final String DESTINATION = "destination";
	public static final String VEHICLE = "vehicle";
	public static final String ACCOMMODATION = "accommodation";
	public static final String DINER = "diner";
	public static final String BUDGET = "budget";
	public static final String REMARK = "remark";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public List<Schedule> findByDestination(Object destination) {
		return findByProperty(Schedule.class, DESTINATION, destination);
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> findByVehicle(Object vehicle) {
		return findByProperty(Schedule.class, VEHICLE, vehicle);
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> findByAccommodation(Object accommodation) {
		return findByProperty(Schedule.class, ACCOMMODATION, accommodation);
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> findByDiner(Object diner) {
		return findByProperty(Schedule.class, DINER, diner);
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> findByBudget(Object budget) {
		return findByProperty(Schedule.class, BUDGET, budget);
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> findByRemark(Object remark) {
		return findByProperty(Schedule.class, REMARK, remark);
	}

	public static ScheduleDaoImple getFromApplicationContext(
			ApplicationContext ctx) {
		return (ScheduleDaoImple) ctx.getBean("ScheduleDaoImple");
	}

	@Override
	public List<Schedule> findByRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}
}