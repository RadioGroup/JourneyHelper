package com.fzu.journeyhelper.dao;

import java.util.Set;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public interface RouteDao extends BaseDao<Route> {

	/**
	 * 查询用户的行程列表
	 * 
	 * @param user
	 * @return
	 */
	public Set<Route> findRoutelistByUser(User user);

	/**
	 * 查询用户的创建列表
	 * 
	 * @param user
	 * @return
	 */
	public Set<Route> findCreatelistByUser(User user);
}
