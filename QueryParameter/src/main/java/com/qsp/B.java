package com.qsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class B extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String mobno = req.getParameter("mobno");
		String age = req.getParameter("age");
		
		resp.getWriter().print("<html><body><h2>Page-B "+name+" "+mobno+" "+age+" "+" </h2></body></html>");
	}

}
