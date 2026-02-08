package com.qsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/display")
public class DisplayData extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String userName = (String)session.getAttribute("un");
		String password = (String)session.getAttribute("password");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("<html><body><h1>Username is "+userName+"</h2></body></html>");
		writer.print("<html><body><h1>Password is "+password+"</h2></body></html>");
		
	}

}
