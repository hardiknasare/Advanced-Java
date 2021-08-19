package tester;

import java.sql.*;
import java.util.Scanner;
import doa.EmployeeDaoImpl;
import pojos.Employee;


public class UpdateEmpDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			EmployeeDaoImpl empDao3 = new EmployeeDaoImpl();
			
			
			System.out.println("Enter emp details : name,  address,  salary,  deptId,  joinDate(yr-mon-day) ");
			String message = empDao3.addEmpDetails(
					new Employee(sc.next(), sc.next(), sc.nextDouble(), sc.next(), Date.valueOf(sc.next())));
			System.out.println("Emp insertion status mesg "+message);
			
			
			empDao3.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}