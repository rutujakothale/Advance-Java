package com.qsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteData extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		System.out.println((String)session.getAttribute("userName"));
		System.out.println((String)session.getAttribute("password"));
		
		session.invalidate();
		
		System.out.println((String)session.getAttribute("userName"));
		System.out.println((String)session.getAttribute("password"));
	}

}
