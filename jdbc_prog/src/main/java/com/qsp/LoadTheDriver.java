package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadTheDriver {
	public static void main(String []args ) {
		try {
			Class.forName("org.postgresql.Driver");
//			System.out.println("Driver Software loaded into the memory");
			
			Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/advancejava", 
					"postgres", "root");
			System.out.println(connection);
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
