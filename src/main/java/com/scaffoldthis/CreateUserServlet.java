package com.scaffoldthis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scaffoldthis.dao.UserDao;
import com.scaffoldthis.dao.UserHibernateDao;

public class CreateUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		new UserHibernateDao().createUser(username, password);

		resp.sendRedirect("login.jsp");
	}
}
