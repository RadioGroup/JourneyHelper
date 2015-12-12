package com.fzu.journeyhelper.service.impl;


import java.util.List;

import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.NotificationManager;

public class NotificationManagerImple extends BaseManager implements
		NotificationManager {

	@Override
	public List<Notification> getUserNotification(User user, Short isHandle) {

		if (isHandle == null) {
			isHandle = Notification.NOTIFICATION_STATUS_NOT_HANDLE;
		}

		List<Notification> notifications = notificationDao
				.findUserNotifications(user, isHandle);
		return notifications;
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
			} else {
				applicantName = applicant.getNickName();
			}
			note.setContent("用户 " + applicantName + " 申请加入 您创建的行程: "
					+ route.getTitle());
			note.setIshandle(Notification.NOTIFICATION_STATUS_NOT_HANDLE);// 设置该通知状态为未读
			note.setType(Notification.NOTIFICATION_TYPE_REPLY_JOIN);// 设置该通知为申请加入的类型
			notificationDao.save(note);
			res = true;
		}

		return res;
	}

	@Override
	public boolean addAapplyJoinNoteToRouteManager(User applicant, User receive) {

		return false;
	}

	@Override
	public boolean agreeUserJoin(Notification notification, short isagree,
			Integer userId) {

		notification = notificationDao.get(Notification.class,
				notification.getNotificationId());
		// 设置该通知已经处理
		notification.setIshandle(Notification.NOTIFICATION_STATUS_HAS_HANDLE);

		Notification agreeNotification = new Notification();

		User sen = notification.getUserByReceiveUserId();
		if (!sen.getUserId().equals(userId)) {
			return false;
		}
		// 接收者和发送者要对调
		User rec = notification.getUserBySendUserId();
		Route route = notification.getRoute();

		// 如果同意加入
		if (isagree == Notification.NOTIFICATION_ANSER_AGREE) {

			rec.getJoinRoutes().add(route);
			// 将用户加入对应的行程
			route.getUsers().add(rec);

			// TODO 向团队里的所有成员发送新队员加入的通知
			// ……

			// 发给该用户一条信息说明他已经被统一加入
			// 设置通知内容
			agreeNotification.setContent("管理员同意您加入行程:" + route.getTitle());

		} else { // 不同意加入
			// 设置通知内容
			agreeNotification.setContent("管理员拒绝您加入行程:" + route.getTitle());

		}
		// 设置通知对应的行程
		agreeNotification.setRoute(route);

		// 设置接收者发送者
		agreeNotification.setUserByReceiveUserId(rec);
		agreeNotification.setUserBySendUserId(sen);

		// 设置未读
		agreeNotification
				.setIshandle(Notification.NOTIFICATION_STATUS_NOT_HANDLE);
		// 设置该通知为回复申请加入类型
		agreeNotification.setType(Notification.NOTIFICATION_TYPE_REPLY_JOIN);

		notificationDao.save(agreeNotification);

		return true;
	}
}
