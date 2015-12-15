package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.domain.RouteCommentReplay;

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
public class RouteCommentReplayDaoImple extends
		BaseDaoHibernate4<RouteCommentReplay> {
	// property constants
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public List<RouteCommentReplay> findByContent(Object content) {
		return findByProperty(RouteCommentReplay.class, CONTENT, content);
	}

	public static RouteCommentReplayDaoImple getFromApplicationContext(
			ApplicationContext ctx) {
		return (RouteCommentReplayDaoImple) ctx.getBean("RouteCommentReplayDaoImple");
	}
}