package com.qsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			String name = req.getParameter("name");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			int id1 = Integer.parseInt(id);
			
				try {
					Class.forName("org.postgresql.Driver");
					Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/servlet_task?user=postgres&password=root");
					PreparedStatement statement = connection.prepareStatement("insert into details values(?,?,?,?)");
					statement.setInt(1, id1);
					statement.setString(2,name);
					statement.setString(3, username);
					statement.setString(4, password);
					
					boolean result=statement.execute();
					
				} catch (ClassNotFoundException | SQLException e) {
					
					e.printStackTrace();
				}		
				
				req.setAttribute("id", id);
				req.setAttribute("name", name);
				req.setAttribute("username", username);
				req.setAttribute("password", password);
				resp.getWriter().print("<html><body><h1>Registered Successfully</h1></body></html>");
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
				requestDispatcher.forward(req, resp);
			
	}
}
