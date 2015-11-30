package com.fzu.journeyhelper.dao.impl;

import java.util.List;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.MyUser;

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
public class UserDaoHibernate extends BaseDaoHibernate4<MyUser> implements
		UserDao {


	
	@Override
	public MyUser findbyUserNameAndPass(MyUser myUser) {

		System.out.println(myUser.toString());

		List<MyUser> list = find(
				"from MyUser as u where u.userName=?0 and u.passWord=?1",
				myUser.getUserName(), myUser.getPassWord());

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public MyUser findbyUserName(MyUser myUser) {

		List<MyUser> list = find("from MyUser as u where u.userName=?0",
				myUser.getUserName());

		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public boolean isExistByUserName(MyUser myUser) {

		if (findbyUserName(myUser) != null) {
			return true;
		} else {
			return false;
		}

	}

}
