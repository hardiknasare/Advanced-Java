package pojos;

import java.sql.Date;

public class User {
	
	private int userId;
	private String name,email,password;
	double role;
	private Date regAmount;
	private String regDate;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String name, String email, String password, double d, Date date, String string) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = d;
		this.regAmount = date;
		this.regDate = string;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	
	
}
