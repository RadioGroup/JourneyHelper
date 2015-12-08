package com.fzu.journeyhelper.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.Schedule;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.RouteManager;

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

		try {
			JSONObject shecduleJsonObject = JSONObject.fromObject(shecduleJson);

			JSONArray scheduleArray = shecduleJsonObject
					.getJSONArray("schedules");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (int i = 0; i < scheduleArray.size(); i++) {
				JSONObject scheduleItem = scheduleArray.getJSONObject(i);
				Schedule newSchedule = new Schedule();

				newSchedule.setAccommodation(scheduleItem
						.getString("accommodation"));
				newSchedule.setBeginTime(sdf.parse(scheduleItem
						.getString("beginTime")));
				newSchedule.setBudget(scheduleItem.getLong("budget"));
				newSchedule.setDestination(scheduleItem
						.getString("destination"));
				newSchedule.setDiner(scheduleItem.getString("diner"));
				newSchedule.setEndTime(sdf.parse(scheduleItem
						.getString("endTime")));
				newSchedule.setRemark((scheduleItem.getString("remark")));
				newSchedule.setVehicle(scheduleItem.getString("vehicle"));
				newSchedule.setRoute(route);

				scheduleDao.save(newSchedule);
				System.out.println(newSchedule.toString());
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Set<Schedule> findRoutesSchedules(Route route) {
		Set<Schedule> schedules = new HashSet<Schedule>();
		schedules.addAll(scheduleDao.findByRoute(route));
		return schedules;
	}

}
