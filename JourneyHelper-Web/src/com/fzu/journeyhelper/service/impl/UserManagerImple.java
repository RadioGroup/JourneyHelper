package com.fzu.journeyhelper.service.impl;

import java.util.Set;

import com.fzu.journeyhelper.action.update.UpdateUserInfoAction;
import com.fzu.journeyhelper.domain.Route;
import com.fzu.journeyhelper.domain.User;
import com.fzu.journeyhelper.service.UserManager;

/**
 * 
 * @author Volcano
 * 
 */
public class UserManagerImple extends BaseManager implements UserManager {

	@Override
	public User loginAuthen(User User) {
		return userDao.findbyUserNameAndPass(User);
	}

	@Override
	public Integer registNewUser(User User) {
		return (Integer) userDao.save(User);
	}

	@Override
	public boolean registAvaliable(User User) {
		return !userDao.isExistByUserName(User);
	}

	@Override
	public Set<User> findRouteMenberList(Route route) {
		route = routeDao.get(Route.class, route.getRouteId());
		Set<User> res = route.getUsers();
		res.size();
		return res;
	}

	@Override
	public int updateUserInfo(User user) {

		int res = UpdateUserInfoAction.UPDATE_USER_INFO_STATUS_SUCCESS;
		User u = userDao.get(User.class, user.getUserId());
		if (u.getPassWord().equals(user.getPassWord())) {
			if (user.getNickName() != null) {
				u.setNickName(user.getNickName());
			}
			if (user.getRealName() != null) {
				u.setNickName(user.getRealName());
			}
			if (user.getSex() != null) {
				u.setSex(user.getSex());
			}
			if (user.getAge() != 200) {
				u.setAge(user.getAge());
			}
			if (user.getJob() != null) {
				u.setJob(user.getJob());
			}
			if (user.getEmail() != null) {
				u.setEmail(user.getEmail());
			}
			if (user.getTelephoneNumber() != null) {
				u.setTelephoneNumber(user.getTelephoneNumber());
			}

			if (user.getLocation() != null) {
				u.setLocation(user.getLocation());
			}
			if (user.getHeadUrl() != null) {
				u.setHeadUrl(user.getHeadUrl());
			}
			userDao.update(u);
			res = UpdateUserInfoAction.UPDATE_USER_INFO_STATUS_SUCCESS;
		} else {
			res = UpdateUserInfoAction.UPDATE_USER_INFO_STATUS_PASS_ERROR;
		}

		return res;
	}

}
