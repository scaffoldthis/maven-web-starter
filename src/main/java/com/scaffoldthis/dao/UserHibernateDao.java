package com.scaffoldthis.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.scaffoldthis.model.User;

public class UserHibernateDao {

	public void createUser(String username, String password) {
		Session session = HibernateUtil.getSession();
		Transaction txn = session.beginTransaction();
		try {
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			session.save(user);
			txn.commit();
		} catch (Exception e) {
			txn.rollback();
		} finally {
			session.close();
		}
	}

	public boolean isValidUser(String username, String password) {
		Session session = HibernateUtil.getSession();
		Transaction txn = session.beginTransaction();
		try {
			Query query = session.createQuery("from User u where u.userName = :name and u.password = :pwd");
			query.setParameter("name", username);
			query.setParameter("pwd", password);
			List list = query.list();
			if (list.isEmpty()) {
				return false;
			}
			if (list.size() == 1) {
				return true;
			}
			return false;
		} finally {
			txn.commit();
			session.close();
		}
	}
}
