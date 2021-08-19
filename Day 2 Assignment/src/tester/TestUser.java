package tester;

import java.util.Scanner;
import dao.UserDaoImpl;
import pojo.User;

public class TestUser {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			UserDaoImpl user1 = new UserDaoImpl();
			System.out.println("Enter email  & Enter password ");
			User userValidate = user1.validateUser(input.next(), input.next());
		
			if(userValidate == null)
				System.out.println("Invalid user");
			else
				System.out.println("Valid user");
		}catch (Exception e) {	
			e.printStackTrace();
		}
		
	}
}
