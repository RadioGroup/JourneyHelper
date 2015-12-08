package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.NotificationManager;

public class NotificationManagerImple extends BaseManager implements
		NotificationManager {

	@Override
	public Set<Notification> getUserNotHandleNotification(User user) {

		Set<Notification> notifications = notificationDao
				.findUserNotifications(user,
						Notification.NOTIFICATION_STATUS_NOT_HANDLE);
		return notifications;
	}

	@Override
	public Set<Notification> getUserHasHandleNotification(User user) {
		// TODO 待解决route懒加载问题
		Set<Notification> notifications = notificationDao
				.findUserNotifications(user,
						Notification.NOTIFICATION_STATUS_HAS_HANDLE);
		return notifications;
	}

	@Override
	public Set<Notification> getUserAllNotification(User user) {
		// TODO 查询用户所有的通知
		return null;
	}

	@Override
	public boolean addAapplyJoinNoteToRoute(User applicant, Route route) {

		boolean res;
		Notification note = new Notification();

		// 加载行程
		route = routeDao.get(Route.class, route.getRouteId());

		User u = route.getUser();

		if (u == null) {
			res = false;
		} else {
			note.setUserByReceiveUserId(u);// 设置该通知的接收者
			note.setUserBySendUserId(applicant);// 设置该通知的发送者
			note.setRoute(route);// 设置通知对应的行程
			String applicantName;
			if (applicant.getNickName() == null
					|| applicant.getNickName().equals("")) {
				if (applicant.getUserName() == null
						|| applicant.getUserName().equals("")) {
					applicantName = applicant.getUserId().toString();
				} else {
					applicantName = applicant.getUserName();
				}
			}else{
				applicantName = applicant.getNickName();
			}
			note.setContent("用户 "+applicantName + " 申请加入 您创建的行程: "
					+ route.getTitle());
			note.setIshandle(Notification.NOTIFICATION_STATUS_NOT_HANDLE);// 设置该通知状态为未读
			note.setType(Notification.NOTIFICATION_TYPE_AGREE_JOIN);// 设置该通知为申请加入的类型
			notificationDao.save(note);
			res = true;
		}

		return res;
	}

	@Override
	public boolean addAapplyJoinNoteToRouteManager(User applicant, User receive) {

		return false;
	}

}
