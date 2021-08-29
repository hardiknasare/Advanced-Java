package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.UserDaoImpl;
import pojos.User;
import pojos.UserRole;


public class RegisterUserByGetCurrentSession {
	public static void main(String[] args) {
		System.out.println("Registering User By Get Current Session");
		
		try (SessionFactory sf = getFactory();Scanner input = new Scanner(System.in);){
			System.out.println("Enter User Details : name, email, password,  confirmPassword, userRole, regDate(yy-mon-day)");
		
		User user = new User(input.next(), input.next(), input.next(),input.next(), UserRole.valueOf(input.next().toUpperCase()),LocalDate.parse( input.next()));
		
		UserDaoImpl dao1 = new UserDaoImpl();
		System.out.println(dao1.registerUserbyWithGetCurrentSession(user));

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
