package com.qsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class CookieExample extends HttpServlet{
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String userName = req.getParameter("userName");
				String password = req.getParameter("password");
				
				if(userName.equals("abc") && password.equals("123")) {
					Cookie cookie1= new Cookie("userName", userName);
					cookie1.setMaxAge(86400);
					resp.addCookie(cookie1);
					
					Cookie cookie2=new Cookie("password", password);
					cookie2.setMaxAge(86400);
					resp.addCookie(cookie2);
					
					resp.getWriter().print("<html><body><h1>Cookie created successfully</h1></body></html>");
				}else {
					resp.getWriter().print("<html><body><h1>Cookie created successfully</h1></body></html>");
				}
			}
}
