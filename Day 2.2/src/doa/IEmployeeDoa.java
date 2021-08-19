package doa;

import java.sql.*;
import java.util.List;
import pojos.Employee;

public interface IEmployeeDoa {
	
	List<Employee> getSelectedEmpDetails(String deptId, String beginDate, String endDate) throws SQLException;
	
	String addEmpDetails(Employee emp) throws SQLException;
	
	String updateEmpDetails(int empId, String newDept, double salIncrement) throws SQLException;
	
}
