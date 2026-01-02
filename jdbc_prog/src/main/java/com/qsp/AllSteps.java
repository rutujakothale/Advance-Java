package com.qsp;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AllSteps {
	public static void main(String[] args) {
		Connection connection=null;
		try {
			Class.forName("org.postgresql.Driver");
//			System.out.println("Driver Software loaded into the memory");
			
			 connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/advancejava", 
					"postgres", "root");
			System.out.println(connection);
			
			Statement statement=connection.createStatement();
			statement.execute("insert into student values(104,'abc',763276633)");
			System.out.println("data saved");
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
