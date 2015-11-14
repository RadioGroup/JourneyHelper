package com.fzu.dao;

import java.util.List;

import com.fzu.model.Image;
import com.fzu.model.Route;
import com.fzu.model.User;

public class ImageDaoHibernate extends PagingHibernateDaoSupport implements
		ImageDao {

	@Override
	public Image get(Integer id) {
		return getHibernateTemplate().get(Image.class, id);
	}

	@Override
	public Integer save(Image image) {
		return (Integer) getHibernateTemplate().save(image);
	}

	@Override
	public void update(Image image) {
		getHibernateTemplate().update(image);
	}

	@Override
	public void delete(Image image) {
		getHibernateTemplate().delete(image);
	}

	@Override
	public void delete(Integer id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public List<Image> findByRoute(Route route) {
		// TODO 增加查询行程照片记录
		return null;
	}

	@Override
	public List<Image> findUserImageByUser(User user) {
		// TODO 增加查询用户照片记录
		return null;
	}

}
