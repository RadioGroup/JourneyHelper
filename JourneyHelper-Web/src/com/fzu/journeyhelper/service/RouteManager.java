package com.fzu.journeyhelper.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.Schedule;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * @author Volcano
 * 
 */
public interface RouteManager {

	public Set<Route> findUserCreateRouteList(User myUser);

	public Set<Route> findUserJoinedRouteList(User myUser);

	public Set<Route> findUserAllRouteList(User user);

	public Integer createARoute(User myUser, Route myRoute);

	public BigInteger findNewRouteCount(Integer userId,Integer Type ,short isJoin);

	public List<Route> findNewRoute(int pageNo, int pageSize, Object... params);

	/**
	 * 给行程添加安排，行程安排项以json格式封装
	 * 
	 * @param shecduleJson
	 * @param route
	 * @return
	 */
	public boolean addScheduleForRoute(String shecduleJson, Route route);

	public Set<Schedule> findRoutesSchedules(Route route);

	public long searchRouteCount(String searchRoute);

	public List<Route> searchRoute(String searchRoute, Integer page,
			Integer pagesize);

}
