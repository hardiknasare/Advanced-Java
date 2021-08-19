package dao;

import java.sql.*;
import pojo.User;
import static utils.DBUtils.fetchDBConnection;

public class UserDaoImpl implements IUserDao {
	private Connection cn;
	private PreparedStatement pst1;
	
	public UserDaoImpl() throws SQLException, ClassNotFoundException{
		cn = fetchDBConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		
		System.out.println(" Constructed...");
	}
	
	@Override
	public User validateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		
		try ( ResultSet rst = pst1.executeQuery()) {
			if(rst.next()) {
				return new User();
			}
		}
		return null;
	}
	
	public void cleanUp() throws SQLException {
		if(pst1 != null) 
			pst1.close();
		System.out.println("Cleaned Up! User Dao");
	}

}
