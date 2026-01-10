package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.postgresql.Driver;

public class GetAllData {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new Driver());	
		
		Connection c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/productdb?user=postgres&password=root");
		
		PreparedStatement statement=c.prepareStatement("select * from product");
//		statement.setInt(1, 102);
		
		ResultSet r=statement.executeQuery();
		
		while(r.next()) {
			System.out.println(r.getInt(1));
			System.out.println(r.getString(2));
			System.out.println(r.getString(3));
			System.out.println(r.getDouble(4));

		}
		
	}
}
