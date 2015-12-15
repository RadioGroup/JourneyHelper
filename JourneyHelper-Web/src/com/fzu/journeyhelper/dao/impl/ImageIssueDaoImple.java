package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.domain.ImageIssue;

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
public class ImageIssueDaoImple extends BaseDaoHibernate4<ImageIssue> {
	// property constants

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
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

	public static ImageIssueDaoImple getFromApplicationContext(ApplicationContext ctx) {
		return (ImageIssueDaoImple) ctx.getBean("ImageIssueDaoImple");
	}
}