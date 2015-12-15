package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.RouteDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

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
public class RouteDaoImple extends BaseDaoHibernate4<Route> implements RouteDao{
	// property constants
	public static final String TITLE = "title";
	public static final String SUMMARY = "summary";
	public static final String ARTICLE = "article";

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public List<Route> findByTitle(Object title) {
		return findByProperty(Route.class, TITLE, title);
	}

	@SuppressWarnings("unchecked")
	public List<Route> findBySummary(Object summary) {
		return findByProperty(Route.class, SUMMARY, summary);
	}

	@SuppressWarnings("unchecked")
	public List<Route> findByArticle(Object article) {
		return findByProperty(Route.class, ARTICLE, article);
	}

	public static RouteDaoImple getFromApplicationContext(ApplicationContext ctx) {
		return (RouteDaoImple) ctx.getBean("RouteDaoImple");
	}

	@Override
	public Set<Route> findRoutelistByUser(User user) {
		return null;
	}

	@Override
	public Set<Route> findCreatelistByUser(User user) {
		return null;
	}
}