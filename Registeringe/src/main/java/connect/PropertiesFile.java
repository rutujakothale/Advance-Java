package connect;

import java.io.FileInputStream;
import java.util.Properties;
//use in case of Db configuration process

public class PropertiesFile {
	public static void main(String[] args) {
		try {
			FileInputStream f=new FileInputStream("db.properties");
			
			Properties properties =new Properties();
			properties.load(f);
			
			String user=properties.getProperty("user");
			System.out.println(user);
			
			String password=properties.getProperty("password");
			System.out.println(password);
			
			String url=properties.getProperty("URL");
			System.out.println(url);
			
			String driverClassPath =properties.getProperty("driverClassPath");
			System.out.println(driverClassPath);
			
			
		}catch (Exception e){
			
		}
		
	}
}
