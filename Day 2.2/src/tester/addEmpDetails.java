package tester;

import java.sql.Date;
import java.util.Scanner;
import doa.EmployeeDaoImpl;
import pojos.Employee;


public class addEmpDetails {
	public static void main(String[] args) {
		try (Scanner input2 = new Scanner(System.in)) {
			EmployeeDaoImpl empDao2 = new EmployeeDaoImpl();
			
			
			System.out.println("Enter emp details : name,  address,  salary,  deptId,  joinDate(yr-mon-day) ");
			String message = empDao2.addEmpDetails( 
			new Employee(input2.next(), input2.next(), input2.nextDouble(), input2.next(), Date.valueOf(input2.next())));
			System.out.println("Emp insertion status mesg "+message);
			
			empDao2.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
