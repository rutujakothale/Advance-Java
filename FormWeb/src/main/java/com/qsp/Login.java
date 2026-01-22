package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			System.out.println("Method executed");
			
			String userName = req.getParameter("userName");
			String password = req.getParameter("password");
			
			System.out.println(userName);
			System.out.println(password);
			
			PrintWriter writer = res.getWriter();
			writer.print("<html><body>");
			writer.print("<h2> Username is:"+userName+" </h2>");
			writer.print("<h3> Password is:"+password+" </h3>");
			writer.print("</html></body>");
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
