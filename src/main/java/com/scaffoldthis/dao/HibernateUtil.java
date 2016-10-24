package com.scaffoldthis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static void setup() {
		if (sessionFactory == null) {
			// A SessionFactory is set up once for an application
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
	}

	public static Session getSession() {
		setup();
		Session openSession = sessionFactory.openSession();
		return openSession;
	}

}
