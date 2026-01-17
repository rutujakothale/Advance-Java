package com.qsp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindbyMobno {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/procedureeg?user=postgres&password=root");
			
			CallableStatement call = conn.prepareCall("select get_by_no(?)");
			call.setLong(1, 846567684);
			
			ResultSet res = call.executeQuery();
			
			res.next();
			System.out.println(res.getString(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
