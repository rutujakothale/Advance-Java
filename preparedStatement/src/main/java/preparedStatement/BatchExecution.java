package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExecution {
	public static void main(String[] args) {
			try {
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/productdb?user=postgres&password=root");
				PreparedStatement statement = connection.prepareStatement("insert into product values(?,?,?,?)");	
				
				statement.setInt(1, 107);
				statement.setString(2,"watch");
				statement.setString(3,"titan");
				statement.setDouble(4, 1100.00);
				
				statement.addBatch();
				
				statement.setInt(1, 108);
				statement.setString(2,"laptop");
				statement.setString(3,"Victus");
				statement.setDouble(4, 71100.00);
				
				statement.addBatch();
				
				statement.setInt(1, 109);
				statement.setString(2,"speakers");
				statement.setString(3,"boat");
				statement.setDouble(4, 4100.00);
				
				statement.addBatch();
				
//				statement.setInt(1, 101);
//				statement.setString(2,"bag");
//				statement.setString(3,"skyBags");
//				statement.setDouble(4, 900.00);
//				
//				statement.addBatch();
				
				int[] executeBatch = statement.executeBatch();
				
				
				System.out.println(executeBatch);
				System.out.println("Data Saved");
				
					
					
			} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
			}
}
}
