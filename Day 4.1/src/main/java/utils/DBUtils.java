package utils;

import java.sql.*;

public class DBUtils {
	private static Connection connection;
	
	public static Connection fetchDBConnection() throws ClassNotFoundException, SQLException{
		if(connection == null) {
			
			
			// fixing db connection
			String url = "jdbc:mysql://localhost:3306/iacsd2?useSSL=false&allowPublicKeyRetrieval=true";
			connection = DriverManager.getConnection(url, "Hardik", "Hn@290598");
		}
		return connection;
	}
	
}
