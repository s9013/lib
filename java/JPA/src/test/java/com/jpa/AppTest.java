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
		// ��ȡʵ�������
		factory = Persistence.createEntityManagerFactory("mysqlJPA");
		// ��ȡʵ�����
		em = factory.createEntityManager();
		// ��������
		em.getTransaction().begin();
	}
	
	@After
	public void close(){
		// �ύ����
		em.getTransaction().commit();
		// �ر�ʵ�����
		em.close();
		// �ر�ʵ�������
		factory.close();
	}
	
	@Test
	public void save() {
		// ����
		em.persist(new User("scorpion", 21));
	}

	@Test
	public void find() {
		// ����
		User user = em.find(User.class, 1);
		System.out.println(user);
	}

	@Test
	public void update() {
		// ����
		User user = em.find(User.class, 1);
		user.setAge(100);// ֱ�Ӹ���
	}

	@Test
	public void delete() {
		// ����
		User user = em.find(User.class, 12);
		// ɾ��
		em.remove(user);
	}
}
