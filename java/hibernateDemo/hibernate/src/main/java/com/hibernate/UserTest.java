package com.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.User;

/**
 * @author Jay
 * @time 2015年8月28日
 */
public class UserTest {
	public static void main(String[] args) {
		
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
        user.setId(5);
        user.setName("Jay");
        user.setBirthday(new Date());
        session.save(user);
        //提交事务
        transction.commit();
        //关闭session
        session.close();
	}

}
