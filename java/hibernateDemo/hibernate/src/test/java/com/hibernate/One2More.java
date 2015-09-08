package com.hibernate;

import org.hibernate.Session;
import org.junit.Test;

import com.hibernate.entity.Student;
import com.hibernate.util.HibernateUtil;

/**
 * @author       Jay
 * @time         2015年9月8日
 */
public class One2More {
	
	@Test
	public void test() {
		Session session = null;
        try {
			session = HibernateUtil.getSession();
			Student student =  session.get(Student.class, 2);
			System.out.println(student);
        } finally {
			if(session != null){
				session.close();
			}
		}
	}

	
	
	
}
