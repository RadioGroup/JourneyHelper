package com.fzu.journeyhelper.service.impl;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.Schedule;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.RouteManager;
import com.fzu.journeyhelper.utils.TimeDateUtil;

/**
 * 
 * @author Volcano
 * 
 */
public class RouteManagerImple extends BaseManager implements RouteManager {

	@Override
	public Set<Route> findUserCreateRouteList(User user) {
		Set<Route> ans = null;
		user = userDao.get(User.class, user.getUserId());
		ans = user.getCreateRoutes();
		ans.size();
		return ans;
	}

	@Override
	public Set<Route> findUserJoinedRouteList(User user) {

		user = userDao.get(User.class, user.getUserId());
		Set<Route> ans = user.getJoinRoutes();
		ans.size();
		return ans;

	}

	@Override
	public Set<Route> findUserAllRouteList(User user) {
		return findUserJoinedRouteList(user);
	}

	@Override
	public Integer createARoute(User user, Route route) {
		user = userDao.get(User.class, user.getUserId());
		route.setUser(user);
		Integer rid = (Integer) routeDao.save(route);
		user.getJoinRoutes().add(route);

		return rid;
	}

	@Override
	public boolean addScheduleForRoute(String shecduleJson, Route route) {

		
		JSONObject shecduleJsonObject = JSONObject.fromObject(shecduleJson);

		JSONArray scheduleArray = shecduleJsonObject.getJSONArray("schedules");

		for (int i = 0; i < scheduleArray.size(); i++) {
			JSONObject scheduleItem = scheduleArray.getJSONObject(i);
			Schedule newSchedule = new Schedule();
			newSchedule.setAccommodation(scheduleItem
					.getString("accommodation"));
			newSchedule.setBeginTime(TimeDateUtil.stringToDate(scheduleItem
					.getString("beginTime")));
			newSchedule.setBudget(scheduleItem.getLong("budget"));
			newSchedule.setDestination(scheduleItem.getString("destination"));
			newSchedule.setDiner(scheduleItem.getString("diner"));
			newSchedule.setEndTime(TimeDateUtil.stringToDate(scheduleItem
					.getString("endTime")));
			newSchedule.setRemark((scheduleItem.getString("remark")));
			newSchedule.setVehicle(scheduleItem.getString("vehicle"));
			newSchedule.setRoute(route);

			try {
				scheduleDao.save(newSchedule);	
			} catch (Exception e) {
				//如果无法插入证明id不存在。
				e.printStackTrace();
				return false;
			}
//			System.out.println(newSchedule.toString());
		}
		return true;
	}

	@Override
	public Set<Schedule> findRoutesSchedules(Route route) {
		Set<Schedule> schedules = new HashSet<Schedule>();
		schedules.addAll(scheduleDao.findByRoute(route));
		return schedules;
	}

	@Override
	public BigInteger findNewRouteCount(Integer userId,Integer Type ,short isJoin) {
		
		return routeDao.findCount(userId,Type,isJoin);
	}
	
	@Override
	public List<Route> findNewRoute(int pageNo, int pageSize,
			Object... params) {
//		String sql = "select * from journeyhelperweb.route re where re.routeId in ("
//				+ "select j.routeId from journeyhelperweb.route_user_relevance j"
//				+ " inner join journeyhelperweb.route r "
//				+ "on j.routeId=r.routeId " + "where j.userId<>?0 "
//				+ "and r.type =?1 )" + "order by re.routeId desc";
//		
//		String hql = "from Route re where re.routeId in ("
//				+ "select r.routeId from Route r"
//				+ " inner join r.users u "
//				+ "where u.userId<>?0 "
//				+ "and r.type =?1 )" + "order by re.routeId desc";
//		
//		String hql2 = "from Route re where re in ("
//				+ "select elements(u.joinRoutes) from User u"
//				+ " where u.userId<>?0 "
//				+ ") " + "and re.type =?1 "+ "order by re.routeId desc";
		
		
		
		return routeDao.findNewRouteByPage(pageNo, pageSize, params);
		
//		
	}

	@Override
	public long searchRouteCount(String searchRoute) {
		return routeDao.findRoutesCount(searchRoute);
	}

	@Override
	public List<Route> searchRoute(String searchRoute, Integer page,
			Integer pagesize) {
		
		return routeDao.findRoutesByPage(searchRoute,  page,
				 pagesize);
	}

	
	
	

}
