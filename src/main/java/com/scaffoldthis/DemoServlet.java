package com.scaffoldthis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals("admin") && password.equals("admin")){
			req.setAttribute("username", "admin");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		else
		{
			resp.sendRedirect("login.jsp");
		}
	}
	
}
