package com.fzu.journeyhelper.dao;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.dao.UserDao       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:04:23     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:04:23     
 * Modified Remark:     
 * @version   V1.0
 */
public interface UserDao extends BaseDao<User> {


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
