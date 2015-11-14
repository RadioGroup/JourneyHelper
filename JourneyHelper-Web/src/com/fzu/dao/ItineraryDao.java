package com.fzu.dao;

import java.util.List;

import com.fzu.model.Itinerary;
import com.fzu.model.Route;

public interface ItineraryDao {
	
	/**
	 * 根据标识属性加载Itinerary实例
	 * @param id
	 * @return
	 */
	public Itinerary get(Integer id);
	
	/**
	 * 持久化指定实例
	 * @param itinerary
	 * @return
	 */
	public Integer save(Itinerary itinerary);
	
	/**
	 * 修改持久化实例
	 * @param itinerary
	 */
	public void update(Itinerary itinerary);
	
	/**
	 * 删除持久化实例
	 * @param itinerary
	 */
	public void delete(Itinerary itinerary);
	
	/**
	 * 根据id删除持久化实例
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 通过行程的规划列表
	 * @param route
	 * @return
	 */
	public List<Itinerary> findByRoute(Route route);
}
