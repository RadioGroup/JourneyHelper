package com.fzu.journeyhelper.service.impl;

import com.fzu.journeyhelper.domain.User;

public interface UserManager {

	public User loginAuthen(User user);

	public Integer registNewUser(User user);

	/**
	 * 判读该用户是否可以注册
	 * @param user
	 * @return
	 */
	public boolean registAvaliable(User user);
	

}
