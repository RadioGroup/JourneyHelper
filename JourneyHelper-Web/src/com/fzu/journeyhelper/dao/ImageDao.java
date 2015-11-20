package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Image;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public interface ImageDao extends BaseDao<Image> {

	
	/**
	 * 查询行程中的照片墙
	 * 
	 * @param route
	 * @return
	 */
	public List<Image> findByRoute(Route route);

	/**
	 * 查询用户发过的照片
	 * 
	 * @param user
	 * @return
	 */
	public List<Image> findByUser(User user);
}
