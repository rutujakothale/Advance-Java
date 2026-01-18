package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


public class SavePoint {
	
	public static boolean isSuccess() {
		return false;
	}
	public static void main(String[] args) {
		String booking_info="insert into booking_info values(4,'Air India','mumbai','bangalore')";
		String passenger= "insert into passenger values(4,'Rose',26,'female')";
		String payment= "insert into payment values(4,6000.0,'online')";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/transaction?user=postgres&password=root");
			connection.setAutoCommit(false);
			
			
			Statement statement2 = connection.createStatement();
			statement2.execute(passenger);
			
			Savepoint savepoint = connection.setSavepoint();
			
			Statement statement = connection.createStatement();
			statement.execute(booking_info);
			
			if(isSuccess()) {
				Statement statement3 = connection.createStatement();
				statement3.execute(payment);
				connection.commit();
				System.out.println("Payment Successful");
			}else {
				System.out.println("Payment Failed");
				connection.rollback(savepoint);
				connection.commit();
			}
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
