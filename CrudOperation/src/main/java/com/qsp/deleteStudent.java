package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteStudent {
	public static void main(String[] args) {
		Connection connection=null;
		try {
			Class.forName("org.postgresql.Driver");
			
			connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation","postgres","root");
			System.out.println(connection);
			
			Statement statement=connection.createStatement();
//			statement.execute("insert into student values(101,'abc',763276633)");
			statement.execute("delete from student where email='abc@gmail'");
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
