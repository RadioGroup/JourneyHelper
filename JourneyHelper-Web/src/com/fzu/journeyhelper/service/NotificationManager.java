package com.fzu.journeyhelper.service;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.domain.Notification;;

public interface NotificationManager {
	
	/**
	 * 获取用户未处理的通知
	 * @param user
	 * @return
	 */
	public Set<Notification> getUserNotHandleNotification(User user);
	
	/**
	 * 获取用户已处理的通知
	 * @param user
	 * @return
	 */
	public Set<Notification> getUserHasHandleNotification(User user);
	
	/**
	 * 获取用户所有的通知
	 * @param user
	 * @return
	 */
	public Set<Notification> getUserAllNotification(User user);
	
	/**
	 * 添加一条向某个行程申请加入的通通知
	 * @param applicant
	 * @param route
	 * @return
	 */
	public boolean addAapplyJoinNoteToRoute(User applicant,Route route);
	
	/**
	 * 添加一条向某个行程管理员申请加入的通通知
	 * @param applicant
	 * @param route
	 * @return
	 */
	public boolean addAapplyJoinNoteToRouteManager(User applicant,User receive);
	
	
}
