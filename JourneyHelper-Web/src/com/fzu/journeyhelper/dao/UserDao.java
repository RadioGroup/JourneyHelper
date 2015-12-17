package com.fzu.journeyhelper.dao;

import java.util.List;

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

	
	public List<User> findUsers(String findkey,Integer pageNo,Integer pageSize);

	public long findUsersCount(String searchUser);
}
