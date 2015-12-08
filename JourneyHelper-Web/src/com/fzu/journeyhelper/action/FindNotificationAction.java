package com.fzu.journeyhelper.action;

import java.util.Set;

import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.User;

public class FindNotificationAction extends BaseAction {

	private Integer status;
	private Integer userId;
	private Integer routeId;
	private Short isHandle;//1表示已经解决，2表示为处理，3表示全部
	private Short type;
	private Set<Notification> notifications;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}


	public void setIsHandle(Short isHandle) {
		this.isHandle = isHandle;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 不要以get起头，不然会当作json要输出的数据
	 * @Tips
	 */
	public String findUserNotHandleNotification() {
		// TODO 加载了route，notification，user三个类产生了三条的查询语句，有待优化 
		User user = new User();
		user.setUserId(userId);
		notifications = notificationManager.getUserNotHandleNotification(user);
		setStatus(201);
		return SUCCESS;
	}

	
}
