package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.MyImage;
import com.fzu.journeyhelper.domain.MyRoute;
import com.fzu.journeyhelper.domain.MyUser;

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
public interface ImageDao extends BaseDao<MyImage> {

	
	/**
	 * 查询行程中的照片墙
	 * 
	 * @param myRoute
	 * @return
	 */
	public List<MyImage> findByRoute(MyRoute myRoute);

	/**
	 * 查询用户发过的照片
	 * 
	 * @param myUser
	 * @return
	 */
	public List<MyImage> findByUser(MyUser myUser);
}
