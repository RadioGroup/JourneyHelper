package com.fzu.journeyhelper.dao;

import java.util.Set;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon Project Name: JourneyHelper-Web
 * 
 * Description: ClassName: com.fzu.journeyhelper.dao.RouteDao Author: Hoatson
 * Create Time: 2015年11月20日 下午6:04:14 Modified By: Modified Time: 2015年11月20日
 * 下午6:04:14 Modified Remark:
 * 
 * @version V1.0
 */
public interface RouteDao extends BaseDao<Route> {

	/**
	 * 查询用户的行程列表
	 * 
	 * @param myUser
	 * @return
	 */
	public Set<Route> findRoutelistByUser(User user);

	/**
	 * 查询用户的创建列表
	 * 
	 * @param myUser
	 * @return
	 */
	public Set<Route> findCreatelistByUser(User user);
}
