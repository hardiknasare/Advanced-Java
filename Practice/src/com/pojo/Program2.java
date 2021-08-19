package com.pojo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Program2 {

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
//			while( rs.next() ) { 
//			
//			Book book = new Book(); // pojo class book	
//			book.setBookId(rs.getInt("book_id"));
//			
//			book.setSubjectName(rs.getString("subject_name"));
//			
//			book.setBookName(rs.getString("book_name"));
//			
//			book.setAuthorName(rs.getString("author_name"));
//
//			book.setPrice(rs.getFloat("price"));
//						
//			System.out.println(book.toString());
//			
//			}
			
			// shorted code
//			while( rs.next() ) { 
//				Book book = new Book(rs.getInt("book_id"),rs.getString("subject_name"),rs.getString("book_name"),rs.getString("author_name"),rs.getFloat("price")); 	
//				System.out.println(book.toString());
//				}
			
			// using collection
			List<Book> books = new ArrayList<>();
			while(rs.next()) {
				Book book = new Book(rs.getInt("book_id"),rs.getString("subject_name"),rs.getString("book_name"),rs.getString("author_name"),rs.getFloat("price"));
				books.add(book);
			}
			books.forEach(System.out::println);
			rs.close();
			
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