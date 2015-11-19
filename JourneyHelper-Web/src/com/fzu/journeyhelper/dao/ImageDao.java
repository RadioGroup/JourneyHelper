package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.journeyhelper.domain.Image;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

public interface ImageDao {

	/**
	 * 根据标识属性加载Itinerary实例
	 * 
	 * @param id
	 * @return
	 */
	public Image get(Integer id);

	/**
	 * 持久化指定实例
	 * 
	 * @param Image
	 * @return
	 */
	public Integer save(Image image);

	/**
	 * 修改持久化实例
	 * 
	 * @param image
	 */
	public void update(Image image);

	/**
	 * 删除持久化实例
	 * 
	 * @param image
	 */
	public void delete(Image image);

	/**
	 * 根据id删除持久化实例
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 查询行程中的照片墙
	 * 
	 * @param route
	 * @return
	 */
	public List<Image> findByRoute(Route route);

	/**
	 * 查询用户发过的照片
	 * 
	 * @param user
	 * @return
	 */
	public List<Image> findUserImageByUser(User user);
}
