package com.fzu.journeyhelper.dao;

import java.math.BigInteger;
import java.util.Set;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon Project Name: JourneyHelper-Web
 * 
 * Description: ClassName: com.fzu.journeyhelper.dao.RouteDao Author: Hoatson
 * Create Time: 2015��11��20�� ����6:04:14 Modified By: Modified Time: 2015��11��20��
 * ����6:04:14 Modified Remark:
 * 
 * @version V1.0
 */
public interface RouteDao extends BaseDao<Route> {

	/**
	 * 查询用户参与的行程
	 * 
	 * @param myUser
	 * @return
	 */
	public Set<Route> findRoutelistByUser(User user);

	/**
	 * 查询用户创建的行程
	 * 
	 * @param myUser
	 * @return
	 */
	public Set<Route> findCreatelistByUser(User user);
	
	public BigInteger findCount(Integer userId,Integer Type ,short isJoin);
}
