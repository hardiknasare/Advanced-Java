package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection connection;

	public static Connection fetchDBConnection() throws ClassCastException, SQLException {
		if (connection == null) {

			String dbURL = "jdbc:mysql://localhost:3306/iacsd2?useSSL=false&allowPublicKeyRetrieval=true";
			connection = DriverManager.getConnection(dbURL, "Hardik", "Hn@290598");
		}
		return connection;

	}
}
