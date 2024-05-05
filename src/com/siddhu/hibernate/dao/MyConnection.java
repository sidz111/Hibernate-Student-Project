package com.siddhu.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyConnection {
	private static EntityManager entityManager = null;
	public static EntityManager getConnection() {
		if(entityManager==null) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("siddhu");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
}
