package com.fzu.journeyhelper.dao;

import java.util.List;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.ImageIssue;
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
 * Create Time: 2015��11��20�� ����6:03:56     
 * Modified By:   
 * Modified Time: 2015��11��20�� ����6:03:56     
 * Modified Remark:     
 * @version   V1.0
 */
public interface ImageIssueDao extends BaseDao<ImageIssue> {

	
	/**
	 * ��ѯ�г��е���Ƭǽ
	 * 
	 * @param myRoute
	 * @return
	 */
	public List<ImageIssue> findByRoute(Route route);

	/**
	 * ��ѯ�û���������Ƭ
	 * 
	 * @param myUser
	 * @return
	 */
	public List<ImageIssue> findByUser(User user);
}
