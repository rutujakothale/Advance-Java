package connect;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class EstablishConnection {
	public static void main(String[] args) {
		try {
			FileInputStream f= new FileInputStream("db.properties");
			
			Properties properties=new Properties();
			properties.load(f);
			
			String driverClassPath=properties.getProperty("driverClassName");
			//Load the specific driver
			Class.forName(driverClassPath);
			
			
			//establish the connection
			String url=properties.getProperty("URL");
			Connection connection =DriverManager.getConnection(url, properties);
			System.out.println(connection);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
