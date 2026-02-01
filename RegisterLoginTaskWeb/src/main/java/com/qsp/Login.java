package com.qsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/servlet_task?user=postgres&password=root");
			PreparedStatement statement = connection.prepareStatement("select * from details where username=? and password=? ");
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet r = statement.executeQuery();
			if(r.next()) {
				if(username.equals(r.getString(3)) && password.equals(r.getString(4))) {
					resp.getWriter().print("<html><body><h1>Logged In Successfully</h1></body></html>");
				}
			}else {
				resp.getWriter().print("<html><body><h1>Invalid username or password</h1></body></html>");
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.html");
				requestDispatcher.include(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
