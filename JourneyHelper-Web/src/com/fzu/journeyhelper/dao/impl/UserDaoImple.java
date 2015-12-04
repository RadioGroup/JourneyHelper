package com.fzu.journeyhelper.dao.impl;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.common.dao.impl.BaseDaoHibernate4;
import com.fzu.journeyhelper.dao.UserDao;
import com.fzu.journeyhelper.domain.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.fzu.journeyhelper.domain.User
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class UserDaoImple extends BaseDaoHibernate4<User> implements UserDao {

	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASS_WORD = "passWord";
	public static final String NICK_NAME = "nickName";
	public static final String REAL_NAME = "realName";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String JOB = "job";
	public static final String EMAIL = "email";
	public static final String TELEPHONE_NUMBER = "telephoneNumber";
	public static final String LOCATION = "location";

	protected void initDao() {
		// do nothing
	}

	@SuppressWarnings("unchecked")
	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {

			List<User> results = (List<User>) getCurrentSession()
					.createCriteria("com.fzu.journeyhelper.domain.User")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> findByUserName(Object userName) {
		return findByProperty(User.class, USER_NAME, userName);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByPassWord(Object passWord) {
		return findByProperty(User.class, PASS_WORD, passWord);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByNickName(Object nickName) {
		return findByProperty(User.class, NICK_NAME, nickName);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByRealName(Object realName) {
		return findByProperty(User.class, REAL_NAME, realName);
	}

	@SuppressWarnings("unchecked")
	public List<User> findBySex(Object sex) {
		return findByProperty(User.class, SEX, sex);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByAge(Object age) {
		return findByProperty(User.class, AGE, age);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByJob(Object job) {
		return findByProperty(User.class, JOB, job);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByEmail(Object email) {
		return findByProperty(User.class, EMAIL, email);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByTelephoneNumber(Object telephoneNumber) {
		return findByProperty(User.class, TELEPHONE_NUMBER, telephoneNumber);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByLocation(Object location) {
		return findByProperty(User.class, LOCATION, location);
	}

	public static UserDaoImple getFromApplicationContext(ApplicationContext ctx) {
		return (UserDaoImple) ctx.getBean("UserDaoImple");
	}

	@Override
	public User findbyUserNameAndPass(User User) {
		System.out.println(User.toString());
		List<User> list = find(
				"from User as u where u.userName=?0 and u.passWord=?1",
				User.getUserName(), User.getPassWord());
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public User findbyUserName(User User) {
		List<User> list = find("from User as u where u.userName=?0",
				User.getUserName());
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public boolean isExistByUserName(User User) {

		if (findbyUserName(User) != null) {
			return true;
		} else {
			return false;
		}

	}
}