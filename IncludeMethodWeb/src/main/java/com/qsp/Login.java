package com.qsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String Password = req.getParameter("password");
		
		if(userName.equals("abc")&& Password.equals("123"))
			resp.getWriter().print("<html><body><h1>Login Succesfull</h1></body></html>");
		else {
			resp.getWriter().print("<html><body><h1>Invalid username or password</h1></body></html>");
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
			requestDispatcher.include(req, resp);
		}
			
}
}
