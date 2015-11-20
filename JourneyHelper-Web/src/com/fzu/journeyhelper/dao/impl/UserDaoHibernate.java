package com.fzu.journeyhelper.dao.impl;

import java.util.List;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * Copyright (C): 2015-Hoatshon  
 * Project Name: JourneyHelper-Web     
 *  
 * Description:   
 * ClassName: com.fzu.journeyhelper.dao.impl.UserDaoHibernate       
 * Author: Hoatson
 * Create Time: 2015年11月20日 下午6:05:11     
 * Modified By:   
 * Modified Time: 2015年11月20日 下午6:05:11     
 * Modified Remark:     
 * @version   V1.0
 */
public class UserDaoHibernate extends BaseDaoHibernate4<User> implements
		UserDao {


	
	@Override
	public User findbyUserNameAndPass(User user) {

		System.out.println(user.toString());

		List<User> list = find(
				"from User as u where u.userName=?0 and u.passWord=?1",
				user.getUserName(), user.getPassWord());

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public User findbyUserName(User user) {

		List<User> list = find("from User as u where u.userName=?0",
				user.getUserName());

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public boolean isExistByUserName(User user) {

		if (findbyUserName(user) != null) {
			return true;
		} else {
			return false;
		}

	}

}
