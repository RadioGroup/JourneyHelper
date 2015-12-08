package com.fzu.journeyhelper.dao;

import java.util.Set;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.User;

public interface NotificationDao extends BaseDao<Notification> {
	public Set<Notification> findUserNotifications(User user, short isHandle);

	public Set<Notification> findUserNotificationByType(User uesr, Short type);

}
