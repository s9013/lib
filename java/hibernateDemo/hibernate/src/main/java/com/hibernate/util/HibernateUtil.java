package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Jay
 * @time 2015年8月28日
 */
public final class HibernateUtil {

	private static final SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	static {
		Configuration conf = new Configuration();
		// 加载主配置 如果名字不是hibernate.cfg.xml 则要写文件名
		conf.configure("hibernate.cfg.xml");
		// 获取SessionFactory
		sessionFactory = conf.buildSessionFactory();
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}

}
