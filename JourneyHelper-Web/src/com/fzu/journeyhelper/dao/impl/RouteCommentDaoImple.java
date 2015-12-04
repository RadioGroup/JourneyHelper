package com.fzu.journeyhelper.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.domain.RouteComment;

/**
 * A data access object (DAO) providing persistence and search support for
 * RouteComment entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.RouteComment
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class RouteCommentDaoImple extends BaseDaoHibernate4<RouteComment> {
	// property constants
	public static final String CONTENT = "content";

	protected void initDao() {
		// do nothing
	}

	public RouteComment findById(java.lang.Integer id) {
		log.debug("getting RouteComment instance with id: " + id);
		try {
			RouteComment instance = (RouteComment) getCurrentSession().get(
					"com.fzu.journeyhelper.domain.RouteComment", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RouteComment> findByContent(Object content) {
		return findByProperty(RouteComment.class, CONTENT, content);
	}

	public static RouteCommentDaoImple getFromApplicationContext(
			ApplicationContext ctx) {
		return (RouteCommentDaoImple) ctx.getBean("RouteCommentDaoImple");
	}
}