package com.fzu.dao;

import java.util.List;

import com.fzu.model.Route;
import com.fzu.model.User;

public interface RouteDao {

	
	/**
	 * 根据标识属性加载Route实例
	 * @param id
	 * @return
	 */
	public Route get(Integer id);
	
	/**
	 * 持久化指定实例
	 * @param route
	 * @return
	 */
	public Integer save(Route route);
	
	/**
	 * 修改持久化实例
	 * @param route
	 */
	public void update(Route route);
	
	/**
	 * 删除持久化实例
	 * @param user
	 */
	public void delete(Route route);
	
	/**
	 * 根据id删除持久化实例
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 查询用户的行程列表
	 * @param user
	 * @return
	 */
	public List<Route> findUserlistByUser(User user);
	
	/**
	 * 查询用户的创建列表
	 * @param user
	 * @return
	 */
	public List<Route> findCreatelistByUser(User user);
}
