package tester;

import java.util.*;
import doa.EmployeeDaoImpl;
import pojos.Employee;

public class GetSelectedEmpDetails {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			EmployeeDaoImpl empDao1 = new EmployeeDaoImpl();
			
			System.out.println("Enter deptId, start date end date(yr-mon-day) ");
			List<Employee> emplist = empDao1.getSelectedEmpDetails(input.next(), input.next(), input.next());
			System.out.println("Emplist : ");
			
			emplist.forEach(System.out::println);
			empDao1.cleanUp();
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

