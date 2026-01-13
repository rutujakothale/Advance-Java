
package procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Callprocedure {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/procedureeg?user=postgres&password=root");
			
			CallableStatement call = connection.prepareCall("call insert_data(?,?,?,?,?)");
			call.setInt(1, 105);
			call.setString(2, "ruth");
			call.setInt(3, 846567684);
			call.setString(4,"ruth@gmail.com");
			call.setString(5, "female");
			
			boolean execute = call.execute();
			System.out.println(execute);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
