package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.jpa.entity.User;

public class AppTest {

	@Test
	public void save() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		em.persist(new User("scorpion", 21));

		em.getTransaction().commit();

		em.close();

		factory.close();
	}

	@Test
	public void find() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		User user = em.find(User.class, 1);

		System.out.println(user);

		em.close();

		factory.close();
	}

	@Test
	public void update() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		User user = em.find(User.class, 9);
		user.setAge(100);
		em.getTransaction().commit();
		em.close();

		factory.close();
	}

	@Test
	public void delete() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysqlJPA");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		User user = em.find(User.class, 9);
		em.remove(user);
		em.getTransaction().commit();
		em.close();

		factory.close();
	}
}
