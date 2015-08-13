package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpa.entity.User;

public class AppTest {

	EntityManagerFactory factory;
	EntityManager em;
	
	@Before
	public void init(){
		// 获取实体管理工厂
		factory = Persistence.createEntityManagerFactory("mysqlJPA");
		// 获取实体管理
		em = factory.createEntityManager();
		// 开启事物
		em.getTransaction().begin();
	}
	
	@After
	public void close(){
		// 提交事物
		em.getTransaction().commit();
		// 关闭实体管理
		em.close();
		// 关闭实体管理工厂
		factory.close();
	}
	
	@Test
	public void save() {
		// 保存
		em.persist(new User("scorpion", 21));
	}

	@Test
	public void find() {
		// 查找
		User user = em.find(User.class, 1);
		System.out.println(user);
	}

	@Test
	public void update() {
		// 更新
		User user = em.find(User.class, 1);
		user.setAge(100);// 直接更改
	}

	@Test
	public void delete() {
		// 查找
		User user = em.find(User.class, 12);
		// 删除
		em.remove(user);
	}
}
