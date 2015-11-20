package com.fzu.journeyhelper.service;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
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
	
	public Set<User> findUsersList(Route route);
}
