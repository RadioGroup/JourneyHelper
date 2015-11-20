package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.Image;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.dao.ImageDao       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:03:56     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:03:56     
 * Modified Remark:     
 * @version   V1.0
 */
public interface ImageDao extends BaseDao<Image> {

	
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
	public List<Image> findByUser(User user);
}
