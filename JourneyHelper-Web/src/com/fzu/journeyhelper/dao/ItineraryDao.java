package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.MyItinerary;
import com.fzu.journeyhelper.domain.MyRoute;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.dao.ItineraryDao       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:04:05     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:04:05     
 * Modified Remark:     
 * @version   V1.0
 */
public interface ItineraryDao extends BaseDao<MyItinerary> {

	/**
	 * 通过行程的规划列表
	 * 
	 * @param myRoute
	 * @return
	 */
	public List<MyItinerary> findByRoute(MyRoute myRoute);
}
