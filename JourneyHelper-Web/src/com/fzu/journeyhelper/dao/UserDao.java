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
 * Create Time: 2015��11��20�� ����6:04:23     
 * Modified By:   
 * Modified Time: 2015��11��20�� ����6:04:23     
 * Modified Remark:     
 * @version   V1.0
 */
public interface UserDao extends BaseDao<User> {


	/**
	 * ͨ���û�������������û�
	 * 
	 * @param user
	 * @return
	 */
	public User findbyUserNameAndPass(User user);

	/**
	 * ͨ���û�����ѯ�û�
	 * 
	 * @param user
	 * @return
	 */
	public User findbyUserName(User user);

	/**
	 * ��ѯ�û��Ƿ����
	 * 
	 * @param user
	 * @return
	 */
	public boolean isExistByUserName(User user);

}