package com.cg.eis.dao;

import java.util.Collection;

import com.cg.eis.bean.Employee;

public interface EmployeeDAO {

	public boolean addEmployee(Employee emp);
	public boolean deleteEmployee(Employee emp);	
	public boolean updateEmployee(Employee emp);
	public Employee findEmployee(int id);
	public Collection<Employee> getAllEmployee();
	
}

