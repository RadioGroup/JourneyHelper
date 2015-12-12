package com.fzu.journeyhelper.action.find;

import java.util.Set;

import com.fzu.journeyhelper.action.BaseAction;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.Schedule;

public class FindRouteSchedulesAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;
	private Integer routeId;
	private Set<Schedule> schedules;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Set<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}

	
	
	@Override
	public String toString() {
		return "FindRouteSchedulesAction [status=" + status + ", routeId="
				+ routeId + ", schedules=" + schedules + "]";
	}

	public String findRouteScheduleList() {
		System.err.println(toString());
		Route route = new Route();
		route.setRouteId(routeId);
		schedules = routeManager.findRoutesSchedules(route);
		return SUCCESS;
	}

}
