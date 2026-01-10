package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class statement {
	public static void main(String[] args) {
		Connection c=null;
		try {
			Class.forName("org.postgresql.Driver");
			
			c= DriverManager.getConnection("jdbc:postgresql://localhost:5432/productdb?user=postgres&password=root");
			
//			PreparedStatement statement=c.prepareStatement("insert into  product values(?,?,?,?)");
//			statement.setInt(1, 101);
			//statement.setString(2,"Pencil");
//			statement.setString(3, "Trimax");
//			statement.setDouble(4,70.0);
			
			
			
//			PreparedStatement statement=c.prepareStatement("update product set product=?,brand=?,price=? where id=?");
//			statement.setString(1,"Pencil");
//			statement.setString(2, "Trimax");
//			statement.setDouble(3,70.0);
//			statement.setInt(4, 101);
			
//			PreparedStatement statement=c.prepareStatement("update product set price=? where id=?");
//			statement.setDouble(1,170.0);
//			statement.setInt(2, 101);
			
			
			PreparedStatement statement=c.prepareStatement("delete from product  where id=?");
			statement.setInt(1, 101);
			
			int res=statement.executeUpdate();   // output in 1 or 0 
			System.out.println(res);
			System.out.println("Data Saved");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
