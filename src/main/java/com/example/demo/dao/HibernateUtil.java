package com.example.demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionfactory();

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	private static SessionFactory buildSessionfactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static void shutdown() {
		sessionFactory.close();
	}
}
