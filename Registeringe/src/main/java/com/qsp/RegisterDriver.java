
package com.qsp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class RegisterDriver {
		public static void main(String[] args) {
			Driver driver =new Driver();
			
			try {
				DriverManager.registerDriver(driver);
				System.out.println("Driver registered successfully");
				
				Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation?user=postgres&password=root");
				System.out.println(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
