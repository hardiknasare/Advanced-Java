package com.pojo;

/* Rules for pojo class : a class which do not extend any class or implement any interface 
 * Rule 1 : Class must be public 
 * Rule 2 : Class should have default constructor
 * Rule 3 : Class should have private fields for every column and getter setter
 * Rule 4 : Class should not contain any business logic method i.e insert update delete..
 * 			It should contain only constructor, methods like getter setter and field
 */
public class Book {
	
	private int bookId;
	private String subjectName,bookName,authorName ;
	private float price;
	
	public Book() {
	}

	public Book(int bookId, String subjectName, String bookName, String authorName, float price) {
		this.bookId = bookId;
		this.subjectName = subjectName;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%-5d %-20s %-65s %40s %-8.2f",bookId,subjectName,bookName,authorName,price);
	}

	
}
