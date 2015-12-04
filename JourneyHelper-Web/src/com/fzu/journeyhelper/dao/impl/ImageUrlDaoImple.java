package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.domain.ImageUrl;

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
public class ImageUrlDaoImple extends BaseDaoHibernate4<ImageUrl> {
	// property constants
	public static final String IMAGE_URL = "imageUrl";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public List<ImageUrl> findByImageUrl(Object imageUrl) {
		return findByProperty(ImageUrl.class, IMAGE_URL, imageUrl);
	}

	public static ImageUrlDaoImple getFromApplicationContext(ApplicationContext ctx) {
		return (ImageUrlDaoImple) ctx.getBean("ImageUrlDaoImple");
	}
}