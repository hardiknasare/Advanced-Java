package pojos;

public class User {
	private String UserName;
	private String Password;
	private int age;
	
	public User() {
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [UserName=" + UserName + ", Password=" + Password + ", age=" + age + "]";
	}

	public User(String userName, String password, int age) {
		super();
		UserName = userName;
		Password = password;
		this.age = age;
	}
	
	
}
