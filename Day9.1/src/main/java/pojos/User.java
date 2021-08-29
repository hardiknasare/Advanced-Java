package pojos; // hibernate independent
import java.time.LocalDate;

import javax.persistence.*;


@Entity // mandatory hain dena hi padta class lvl anotation
@Table(name = "users_tbl")//specifies table name
public class User {
	/* columns to be inserted in table
	 * userId(primary key), name, email (unique), password, enum(role), confirmPassword, regAmount;
	 * LocalDate/Date regDate; byte[] image
 	 */
	
	@Id // primary key hain mandatory : PK constraint
	//@GeneratedValue //hibernate default DB  
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment karne ke liye
	// most suitable hain Identity strategy
	@Column(name = "user_id")
	private Integer userId;
	@Column(length = 20) // varchar = 20
	private String name;
	@Column(length = 20, unique = true)// unique karne ke liye
	private String email;
	@Column(length = 20, nullable = false)// not null karna hain toh
	private String password;
	@Transient // agar skip karna hain persistent se toh yeh likhenge
	private String confirmPassword;
	@Enumerated(EnumType.STRING)
	//sirf enumerated diya toh default oridinal hota hain 
	//hame name chayiye isliye hum string likhte hain anotation mein
	@Column(name = "user_role")
	private UserRole userRole;
	@Column(name = "reg_date")
	private LocalDate regDate;
	@Lob // column type blob= medium
	private byte[] image;
	
	public User() {  // must for deserialization
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, String confirmPassword, UserRole userRole,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.userRole = userRole;
		this.regDate = regDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", userRole=" + userRole + ", regDate= " + regDate + "]"  ;
	}
	
}
