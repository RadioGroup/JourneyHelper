package com.fzu.journeyhelper.action;

import com.fzu.journeyhelper.domain.Notification;

public class HandleNotificationAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;

	private Integer notificationId;
	private short isAgree;
	private	Integer userId;
	
	
	public Integer getStatus() {
		return status;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public void setIsAgree(short isAgree) {
		this.isAgree = isAgree;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String agreeJoinRoute() {
		if(userId==null||notificationId==null){
			status =202;
			return ERROR;
		}
		Notification notification = new Notification();
		notification.setNotificationId(notificationId);
		if(notificationManager.agreeUserJoin(notification, isAgree,userId)){			
			status = 201;
		}else{
			status = 202;
		}
		return SUCCESS;
	}

	public String handleNotification() {
		if(userId==null||notificationId==null){
			status =202;
			return ERROR;
		}
		Notification notification = new Notification();
		notification.setNotificationId(notificationId);
		if(notificationManager.handleNotification(notification,userId)){			
			status = 201;
		}else{
			status = 202;
		}
		return SUCCESS;
	}
	
}
