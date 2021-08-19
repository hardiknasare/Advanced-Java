package pojos;

import java.sql.*;

public class Employee {
	private int empid;
	private String name, addr, deptid ; 
	private double salary ;
	private Date join_date;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empid, String name, double salary, Date join_date) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.join_date = join_date;
	}
	
	public Employee(String name, String addr, double salary, String deptid, Date join_date) {
		super();
		this.name = name;
		this.addr = addr;
		this.deptid = deptid;
		this.salary = salary;
		this.join_date = join_date;
	}
	
	public Employee(int empid, String name, String addr, String deptid, double salary, Date join_date) {
		super();
		this.empid = empid;
		this.name = name;
		this.addr = addr;
		this.deptid = deptid;
		this.salary = salary;
		this.join_date = join_date;
	}


	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", addr=" + addr + ", deptid=" + deptid + ", salary="
				+ salary + ", join_date=" + join_date + "]";
	}
	
	
}
