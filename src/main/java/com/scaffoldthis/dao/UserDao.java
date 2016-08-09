package com.scaffoldthis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {

	private String username = "root";
	private String password = "root";

	public UserDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void createUser(String username, String password) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = getConnection();
			stmt = connection.prepareStatement("insert into app_user(user_name,password) value(?,?)");
			stmt.setString(1, username);
			stmt.setString(2, password);
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isValidUser(String username, String password) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			stmt = connection.prepareStatement("select * from app_user where user_name = ? and password = ?");
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()){
				// We dont need to see the data as long as there is a user with given username and password
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public Connection getConnection() throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_app", username, password);
		connection.setAutoCommit(false);
		return connection;
	}
}
