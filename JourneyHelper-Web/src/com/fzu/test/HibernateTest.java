package com.fzu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.fzu.journeyhelper.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
@Transactional
public class HibernateTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private User user;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Test
	public void test() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		user.setUserName("root");
		user.setPassWord("root");
		user.setNickName("»á·ÉµÄÖí");
		user.setEmail("Hoatson@qq.com");
		user.setTelephone("18859976557");
		user.setHeadUrl("www.baidu.com");

		session.save(user);
		transaction.commit();
		session.close();
	}

}
