package com.fzu.journeyhelper.action.find;

import java.util.List;

import com.fzu.journeyhelper.action.BaseAction;
import com.fzu.journeyhelper.domain.Notification;
import com.fzu.journeyhelper.domain.User;

public class FindNotificationAction extends BaseAction {

	private Integer status;
	private Integer userId;
	private Short isHandle;// 1表示已经解决，2表示为处理，3表示全部
	private List<Notification> notifications;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setIsHandle(Short isHandle) {
		this.isHandle = isHandle;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 不要以get起头，不然会当作json要输出的数据
	 * 
	 * @Tips
	 */
	public String findUserNotification() {
		// TODO 加载了route，notification，user三个类产生了三条的查询语句，有待优化
		User user = new User();
		user.setUserId(userId);
		notifications = notificationManager.getUserNotification(user, isHandle);
		System.out.println(notifications.get(0).getCreateTime().toString());
		setStatus(201);
		return SUCCESS;
	}

}
