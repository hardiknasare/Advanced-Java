package dao;
import pojos.User;

public interface IUserDao {
	String registerUser(User user);
	String registerUserbyWithGetCurrentSession(User user);
	
	User getUserDetails(int userId);
}
