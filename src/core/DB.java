package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		if(conn == null) {
			
			try {
				
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				conn = DriverManager.getConnection(url, properties);
				
			} catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		return conn;
		
	}
	
	public static Properties loadProperties() {
		
		Properties properties = new Properties();

		
		try(FileInputStream fs = new FileInputStream("db.properties")){
			
			properties.load(fs);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return properties;

		
	}
	
	
	public static void closeConnection() {
		
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	

}