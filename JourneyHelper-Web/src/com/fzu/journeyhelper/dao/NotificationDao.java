package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.User;

public interface NotificationDao extends BaseDao<Notification> {
	public List<Notification> findUserNotifications(User user, short isHandle);

	public List<Notification> findUserNotificationByType(User uesr, Short type);

}
