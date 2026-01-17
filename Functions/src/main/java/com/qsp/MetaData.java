package com.qsp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaData {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/procedureeg?user=postgres&password=root");
			
			PreparedStatement statement = connection.prepareStatement("select * from student");
			ResultSet r = statement.executeQuery();
			
			ResultSetMetaData data = r.getMetaData();
			System.out.println(data.getColumnCount());
			System.out.println(data.getColumnClassName(1));
			System.out.println(data.getColumnLabel(1));
			System.out.println(data.getColumnLabel(2));
			System.out.println(data.getColumnLabel(3));
			System.out.println(data.getColumnType(2));
			
//			DatabaseMetaData metaData = connection.getMetaData();
//			System.out.println(metaData.getDriverVersion());
//			System.out.println(metaData.getDriverName());
//			System.out.println(metaData.supportsGroupBy());
//			System.out.println(metaData.supportsMultipleTransactions());
//			System.out.println(metaData.supportsBatchUpdates());
//			System.out.println(metaData.supportsCorrelatedSubqueries());
//			System.out.println(metaData.supportsUnionAll());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
