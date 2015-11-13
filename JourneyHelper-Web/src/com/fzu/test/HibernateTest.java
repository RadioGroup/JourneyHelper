package com.fzu.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fzu.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class HibernateTest {

	private SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Test
	public void test() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setUserName("root");
		user.setPassWord("root");
		user.setUserId("rootroot");
		user.setNickName("»á·ÉµÄÖí");
		user.setEmail("Hoatson@qq.com");
		user.setTelephone("18859976557");
		user.setHeadUrl("www.baidu.com");

		session.save(user);
		transaction.commit();
		session.close();
	}

}
//
//org.springframework.beans.factory.BeanCreationException: 
//	Error creating bean with name 'com.fzu.test.HibernateTest': 
//		Injection of autowired dependencies failed; 
//nested exception is org.springframework.beans.factory.BeanCreationException: 
//	Could not autowire field: 
//		org.hibernate.SessionFactory 
//		com.fzu.test.HibernateTest.sessionFactory; 
//nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No matching bean of type [org.hibernate.SessionFactory] 
//		found for dependency: expected at least 1 bean which qualifies as autowire 
//		candidate for this dependency. Dependency 
//		annotations: {@org.springframework.beans.factory.annotation.Autowired
//	(required=true)}	
//at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(
//		AutowiredAnnotationBeanPostProcessor.java:287)	
//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean
//		(AbstractAutowireCapableBeanFactory.java:1106)	
//		at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireBeanProperties
//		(AbstractAutowireCapableBeanFactory.java:374)	
//		at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies
//		(DependencyInjectionTestExecutionListener.java:110)	
//		at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance
//		(DependencyInjectionTestExecutionListener.java:75)	
//		at org.springframework.test.context.TestContextManager.prepareTestInstance
//		(TestContextManager.java:321)	
//		at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:211)	
//		at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:288)	
//		at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)	
//		at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:290)	
//		at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:231)	
//		a
