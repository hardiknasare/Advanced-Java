package doa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pojos.Employee;
import static utils.DBUtils.fetchDBConnection;

public class EmployeeDaoImpl implements IEmployeeDoa {
	// fields/ state
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException{
		cn = fetchDBConnection();
		String sql = "select empid,name,salary,join_date from my_emp where deptid = ? and join_date between ? and ?";
		pst1 = cn.prepareStatement(sql);
		
		pst2 = cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		
		pst3 = cn.prepareStatement("update my_emp set deptid = ?,salary = salary+? where empid=? ");
		System.out.println("Emp Doa created");
		
	}
	
	
	@Override
	public List<Employee> getSelectedEmpDetails(String deptId, String beginDate, String endDate) throws SQLException {
		List<Employee> list = new ArrayList<>();
		
		// set In params 
		pst1.setString(1,deptId);
		pst1.setDate(2, Date.valueOf(beginDate));
		pst1.setDate(3, Date.valueOf(endDate));
		
		// executing query
		try ( ResultSet rst = pst1.executeQuery())  {
			while(rst.next())
				list.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
		}
		
		return list;
	}

	@Override
	public String addEmpDetails(Employee emp) throws SQLException {
		// name    | addr    | salary | deptid | join_date
		// string  |string	 |double  |string  |date
		
		pst2.setString(1,emp.getName());
		pst2.setString(2,emp.getAddr());
		pst2.setDouble(3, emp.getSalary());
		pst2.setString(4, emp.getDeptid());
		pst2.setDate(5, emp.getJoin_date());
		int updateCount = pst2.executeUpdate();
		if(updateCount == 1)
			return "Emp details inserted";
		return "Emp details failed to insert";
		
	}

	@Override
	public String updateEmpDetails(int empId, String newDept, double salIncrement) throws SQLException {
		// set In params : 
		
		pst3.setString(1, newDept);
		pst3.setDouble(2, salIncrement);
		pst3.setInt(3, empId);
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "emp details updated";
		return "failed";		
	}
	
	public void cleanUp() throws SQLException{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		if(pst3 != null)
			pst3.close();
		System.out.println("pst closed.... lockdown");
	}
}
