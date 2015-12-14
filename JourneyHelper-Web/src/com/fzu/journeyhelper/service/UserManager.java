package com.fzu.journeyhelper.service;

import java.util.Set;

import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * @author Volcano
 * 
 */
public interface UserManager {

	public User loginAuthen(User User);

	public Integer registNewUser(User User);

	/**
	 * 检查账户名是否存在
	 * 
	 * @param User
	 * @return
	 */
	public boolean registAvaliable(User user);

	public Set<User> findRouteMenbers(Route route);
	
	public int updateUserInfo(User user);

}
