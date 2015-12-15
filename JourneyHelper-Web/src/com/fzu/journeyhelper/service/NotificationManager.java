package com.fzu.journeyhelper.service;

import java.util.List;

import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public interface NotificationManager {
	
	/**
	 * 获取用户通知
	 * @param user
	 * @return
	 */
	public List<Notification> getUserNotification(User user,Short isHandle);
	
	/**
	 * 添加一条向某个行程申请加入的通通知
	 * @param applicant
	 * @param route
	 * @return
	 */
	public boolean addAapplyJoinNoteToRoute(User applicant,Route route);
	
	/**
	 * 添加一条向某个行程管理员同意申请加入的通通知
	 * @param applicant
	 * @param route
	 * @return
	 */
	public boolean addAapplyJoinNoteToRouteManager(User applicant,User receive);
	
	/**
	 * 处理申请加入，同意某用户申请加入
	 * @param notification
	 * @return
	 */
	public boolean agreeUserJoin(Notification notification,short isagree,Integer userId);
}
