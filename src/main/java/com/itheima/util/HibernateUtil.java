package com.itheima.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static Session session ;
	static{
		
		Configuration configure = new Configuration().configure();
		SessionFactory sessionFactory = configure.buildSessionFactory();
		session = sessionFactory.openSession();
	}
	
	public static Session getSession(){
		return session;
	} 
	
	
	public static Session getAnnotationSession(){
		
		Configuration configure = new Configuration().configure("hibernate.annotation.cfg.xml");
		SessionFactory sessionFactory = configure.buildSessionFactory();
		return sessionFactory.openSession();
	}
}
