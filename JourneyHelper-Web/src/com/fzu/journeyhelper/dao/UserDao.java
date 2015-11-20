package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public interface UserDao extends BaseDao<User> {

	/**
	 * 通过行程查询队员列表
	 * 
	 * @param route
	 * @return
	 */
	public List<User> findByRoute(Route route);

	/**
	 * 通过用户名和密码查找用户
	 * 
	 * @param user
	 * @return
	 */
	public User findbyUserNameAndPass(User user);

	/**
	 * 通过用户名查询用户
	 * 
	 * @param user
	 * @return
	 */
	public User findbyUserName(User user);

	/**
	 * 查询用户是否存在
	 * 
	 * @param user
	 * @return
	 */
	public boolean isExistByUserName(User user);

}
