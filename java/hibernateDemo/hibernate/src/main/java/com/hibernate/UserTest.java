package com.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;

/**
 * @author Jay
 * @time 2015年8月28日
 */
public class UserTest {
	public static void main(String[] args) {
//		User user = new User();
//		user.setName("Mike 1");
//		UserTest.addUser(user);
		
		//System.out.println(find(3).getName());
		
		//delete(3);
		//System.out.println(findByHql(1).getName());
	
//		User user = new User();
//		user.setId(1);
//		user.setName("Mike123");
//		user.setBirthday(new Date());
//		update(user);
		
		findAllByHql();
	
	}
	
	void test(){
		Configuration conf = new Configuration();
        //加载主配置
        conf.configure("/hibernate.cfg.xml");
        //获取SessionFactory
        SessionFactory sf = conf.buildSessionFactory();
        //获取Session
        Session session = sf.openSession();
        //开启事务
        Transaction transction = session.beginTransaction();
        //执行添加操作
        User user = new User();
        user.setName("Jay");
        user.setBirthday(new Date());
        session.save(user);
        //提交事务
        transction.commit();
        //关闭session
        session.close();
	}

	static void addUser(User user){
		Session session = null;
		Transaction tx = null;
        try {
			session = HibernateUtil.getSession();
			//开启事务
			tx = session.beginTransaction();
			//执行添加操作
			session.save(user);
			
			user.setName("new name");
			//提交事务
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null){
				tx.rollback();
			}
			throw e;
		} finally {
			//关闭session
			if(session != null){
				session.close();
			}
		}
	}
	
	static void addUser1(User user){
		Session session = null;
		Transaction tx = null;
        try {
			session = HibernateUtil.getSession();
			//开启事务
			tx = session.beginTransaction();
			//执行添加操作
			session.save(user);
			//提交事务
			tx.commit();
		} finally {
			//关闭session
			if(session != null){
				session.close();
			}
		}
	}
	
	
	static User find(int id){
		Session session = null;
		User user = new User();
        try {
			session = HibernateUtil.getSession();
			user = session.get(User.class, id);
		} finally {
			//关闭session
			if(session != null){
				session.close();
			}
		}
        return user;
	}
	
	static User find2(int id){
		Session session = null;
		User user = new User();
        try {
			session = HibernateUtil.getSession();
			user = session.get(User.class, id);
		} finally {
			//关闭session
			if(session != null){
				session.close();
			}
		}
        return user;
	}
	
	static User delete(int id){
		Session session = null;
		Transaction tx = null;
		User user = new User();
        try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
//			session.delete(session.get(User.class, id));
			user.setId(2);
			session.delete(user);
			tx.commit();
		} finally {
			//关闭session
			if(session != null){
				session.close();
			}
		}
        return user;
	}
	
	/**
	 * HQL
	 * @param id
	 */
	static User findByHql(int id){
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from User where id=:id");
			query.setParameter("id", id);
			
			List<User> list = query.list();
			
			user = (User) query.uniqueResult();
		} finally {
			if(session != null){
				session.close();
			}
		}
		return user;
	}
	
	/**
	 * HQL
	 * @param id
	 */
	static void findAllByHql(){
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query query = session.createQuery("from User");
			List<User> list = query.list();
			for(User user: list){
				System.out.println(user.getName());
			}
		} finally {
			if(session != null){
				session.close();
			}
		}
	}
	
	static void update(User user){
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx= session.getTransaction();
			tx.begin();
			session.update(user);
			user.setName("持久化");
			tx.commit();
		} finally {
			if(session != null){
				session.close();
			}
		}
	}
	
	
}
