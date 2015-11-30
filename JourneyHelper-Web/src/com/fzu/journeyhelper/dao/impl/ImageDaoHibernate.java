package com.fzu.journeyhelper.dao.impl;

import java.util.List;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.ImageDao;
import com.fzu.journeyhelper.domain.MyImage;
import com.fzu.journeyhelper.domain.MyRoute;
import com.fzu.journeyhelper.domain.MyUser;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.dao.impl.ImageDaoHibernate       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:04:52     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:04:52     
 * Modified Remark:     
 * @version   V1.0
 */
public class ImageDaoHibernate extends BaseDaoHibernate4<MyImage> implements
		ImageDao {

	@Override
	public List<MyImage> findByRoute(MyRoute myRoute) {
		// TODO 增加查询行程照片记录
		return null;
	}

	@Override
	public List<MyImage> findByUser(MyUser myUser) {
		// TODO 增加查询用户照片记录
		return null;
	}

}
