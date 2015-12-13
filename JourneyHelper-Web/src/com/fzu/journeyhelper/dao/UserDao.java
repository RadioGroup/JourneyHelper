package com.fzu.journeyhelper.dao;

import com.fzu.common.dao.BaseDao;
import com.fzu.journeyhelper.domain.User;

/**
 * 
 * @author Volcano
 * 
 */
public interface UserDao extends BaseDao<User> {

	/**
	 * ͨ���û������������û�
	 * 
	 * @param User
	 * @return
	 */
	public User findbyUserNameAndPass(User User);

	/**
	 * ͨ���û����ѯ�û�
	 * 
	 * @param User
	 * @return
	 */
	public User findbyUserName(User User);

	/**
	 * ��ѯ�û��Ƿ����
	 * 
	 * @param User
	 * @return
	 */
	public boolean isExistByUserName(User User);

}
