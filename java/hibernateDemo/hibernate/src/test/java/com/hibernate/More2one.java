package com.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hibernate.entity.Grade;
import com.hibernate.util.HibernateUtil;

/**
 * @author       Jay
 * @time         2015年9月8日
 */
public class More2one {

	
	private Gson gson = new GsonBuilder().serializeNulls().create();
	
	@Test
	public void test() {
		Session session = null;
        try {
			session = HibernateUtil.getSession();
			Grade grade =  session.get(Grade.class, 2);
			System.out.println(gson.toJson(grade));
		} finally {
			if(session != null){
				session.close();
			}
		}
	}

	
	
	
}
