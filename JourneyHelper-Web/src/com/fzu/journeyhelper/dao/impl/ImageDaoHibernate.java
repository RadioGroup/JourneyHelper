package com.fzu.journeyhelper.dao.impl;

import java.util.List;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.ImageDao;
import com.fzu.journeyhelper.domain.Image;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public class ImageDaoHibernate extends BaseDaoHibernate4<Image> implements
		ImageDao {

	@Override
	public List<Image> findByRoute(Route route) {
		// TODO 增加查询行程照片记录
		return null;
	}

	@Override
	public List<Image> findByUser(User user) {
		// TODO 增加查询用户照片记录
		return null;
	}

}
