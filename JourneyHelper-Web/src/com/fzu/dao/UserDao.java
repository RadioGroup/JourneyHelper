package com.fzu.dao;

import java.util.List;

import com.fzu.model.Route;
import com.fzu.model.User;


public interface UserDao{
	
	/**
	 * 根据标识属性加载User实例
	 * @param id
	 * @return
	 */
	public User get(Integer id);
	
	/**
	 * 持久化指定实例
	 * @param user
	 * @return
	 */
	public Integer save(User user);
	
	/**
	 * 修改持久化实例
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * 删除持久化实例
	 * @param user
	 */
	public void delete(User user);
	
	/**
	 * 根据id删除持久化实例
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 通过行程查询队员列表
	 * @param route
	 * @return
	 */
	public List<User> findByRoute(Route route);
	
	/**
	 * 通过用户名和密码查找用户
	 * @param user
	 * @return
	 */
	public User findbyUserNameAndPass(User user);
		
}
