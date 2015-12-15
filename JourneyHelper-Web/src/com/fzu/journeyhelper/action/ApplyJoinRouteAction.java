package com.fzu.journeyhelper.action;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public class ApplyJoinRouteAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer userId;
	private String userName;
	private String nickName;
	private Integer routeId;// 申请加入的行程id;	
	private Integer status;// 201,202;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String applyJoinRoute() {

		User au = new User();
		au.setUserId(userId);
		au.setUserName(userName);
		au.setNickName(nickName);
		Route route = new Route();
		route.setRouteId(routeId);
		if (notificationManager.addAapplyJoinNoteToRoute(au, route)) {
			status = 201;
		} else {
			status = 202;
		}
		return SUCCESS;
	}
}
