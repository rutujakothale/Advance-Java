package com.qsp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class GetAllData {
		public static void main(String[] args)  throws Exception{
			Class.forName("org.postgresql.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudoperation","postgres","root");
			Statement statement=connection.createStatement();
			
			ResultSet r= statement.executeQuery("select * from student where mobileno=947364738");
			
			while(r.next()) {
				System.out.println(r.getInt(1));
				System.out.println(r.getString(2));
				System.out.println(r.getLong(3));
				System.out.println(r.getString(4));
//				System.out.println(r.getDouble(5));
				System.out.println("--------------------");
			}
		}
}
