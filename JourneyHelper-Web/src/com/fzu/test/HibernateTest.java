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

import com.fzu.journeyhelper.domain.MyUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
@Transactional
public class HibernateTest {
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private MyUser myUser;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MyUser getUser() {
		return myUser;
	}

	public void setUser(MyUser myUser) {
		this.myUser = myUser;
	}

	@Test
	public void test() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		myUser.setUserName("root");
		myUser.setPassWord("root");
		myUser.setNickName("»á·ÉµÄÖí");
		myUser.setEmail("Hoatson@qq.com");
		myUser.setTelephone("18859976557");
		myUser.setHeadUrl("www.baidu.com");

		session.save(myUser);
		transaction.commit();
		session.close();
	}

}
