package tester;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;


public class GetUserDetails {
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();Scanner input = new Scanner(System.in);){
			System.out.print("Enter UserID : ");
			int userId = input.nextInt();
		UserDaoImpl dao1 = new UserDaoImpl();
		User temp = dao1.getUserDetails(userId);
		
		if( temp != null) {
			System.out.println("User Found");
			System.out.println(temp.toString());
		}
		else
		System.out.println("User not Found");
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
