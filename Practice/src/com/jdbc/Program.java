package com.jdbc;

import java.sql.*;

public class Program {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			
			// Step 1 : Load and register driver
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			// step 2 : Establish Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","Hardik","Hn@290598");
		
			//Step 3 : Create Statement / PreparedStatement / CallableStatement object
			statement = connection.createStatement();
			
			//Step 4 : Prepare and Execute query
			String sql = "SELECT * FROM books";
			ResultSet rs = statement.executeQuery(sql);
			while( rs.next() ) { 
			
			int bookId = rs.getInt("book_id");
			String subjectName = rs.getString("subject_name");
			String bookName = rs.getString("book_name");
			String authorName = rs.getString("author_name");
			float price = rs.getFloat("price");
			
			System.out.printf("%-5d %-20s %-65s %40s %-8.2f\n",bookId,subjectName,bookName,authorName,price);
			
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally {
			
			// Step 5 : close resources
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
