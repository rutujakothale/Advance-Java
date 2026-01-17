package com.qsp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindbyGender {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			Class.forName("org.postgresql.Driver");
			 connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/procedureeg?user=postgres&password=root");
			
			CallableStatement call= connection.prepareCall("select countby_gender(?)");
			
			call.setString(1, "female");
			
			ResultSet r = call.executeQuery();
			
			r.next();
			System.out.println(r.getInt(1));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
