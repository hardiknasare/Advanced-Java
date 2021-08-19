package utils;

import java.sql.*;

public class DButils {
	private static Connection connection;

	public static Connection fetchDBConnetion() throws ClassNotFoundException, SQLException {
		if (connection == null) {
		//	Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/iacsd2?useSSL=false&allowPublicKeyRetrieval=true";
			connection = DriverManager.getConnection(url, "Hardik", "Hn@290598");
		}
		return connection;
	}
}