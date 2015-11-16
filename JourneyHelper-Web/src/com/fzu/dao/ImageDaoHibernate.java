package com.fzu.dao;

import java.util.List;

import com.fzu.model.Image;
import com.fzu.model.Route;
import com.fzu.model.User;

public class ImageDaoHibernate extends PagingHibernateDaoSupport implements
		ImageDao {

	@Override
	public Image get(Integer id) {
		return (Image) getSessionFactory().getCurrentSession().get(Image.class, id);
	}

	@Override
	public Integer save(Image image) {
		return (Integer) getSessionFactory().getCurrentSession().save(image);
	}

	@Override
	public void update(Image image) {
		getSessionFactory().getCurrentSession().update(image);
	}

	@Override
	public void delete(Image image) {
		getSessionFactory().getCurrentSession().delete(image);
	}

	@Override
	public void delete(Integer id) {
		getSessionFactory().getCurrentSession().delete(get(id));
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
