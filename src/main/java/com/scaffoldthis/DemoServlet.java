package com.scaffoldthis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String html = "<html>\n" + 
				"	<head>\n" + 
				"		\n" + 
				"	</head>\n" + 
				"	<body>\n" + 
				"		<form action=\"/hello\" method=\"post\">\n" + 
				"			<input type=\"text\" placeholder=\"Username\" name=\"username\"><br/>\n" + 
				"			<input type=\"password\" placeholder=\"Password\" name=\"password\"><br/>\n" + 
				"			<input type=\"submit\" value=\"login\">\n" + 
				"		</form>\n" + 
				"	</body>\n" + 
				"</html>";
		resp.getWriter().println(html);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals("admin") && password.equals("admin")){
			resp.getWriter().println("Welcome Admin");
		}
		else
		{
			resp.getWriter().println("Invalid login");
		}
	}
	
}
