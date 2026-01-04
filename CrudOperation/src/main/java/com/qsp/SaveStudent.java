package com.qsp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SaveStudent {
public static void main(String[] args) {
	Connection connection=null;
	try {
		Class.forName("org.postgresql.Driver");
		
		connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation","postgres","root");
		System.out.println(connection);
		
		Statement statement=connection.createStatement();
//		statement.execute("insert into student values(103,'java',4749476633,'java@gmail')");
		statement.execute("update student set mobileno=947364738 where name='java'");
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
