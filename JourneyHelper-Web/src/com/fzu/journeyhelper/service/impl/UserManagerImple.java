package com.fzu.journeyhelper.service.impl;

import java.util.Set;

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
		// return res;
		return res;
	}

}
