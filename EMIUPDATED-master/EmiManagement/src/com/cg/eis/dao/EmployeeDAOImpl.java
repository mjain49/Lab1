package com.cg.eis.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.cg.eis.bean.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	Map<Integer,Employee> empList= new HashMap<>();
	
	//ADDING THE EMPLOYEE
	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try
		{
		empList.put(emp.getEmpId(), emp);
		System.out.println("Employee Added Successfully");
		return true;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}
	
	
	
	@Override
	public boolean deleteEmployee(Employee emp) {
		try
		{
			empList.remove(emp.getEmpId(), emp);
			return true;
		} catch( NullPointerException e ) {
			return false;
		}
	}
	@Override
	public boolean updateEmployee(Employee emp) {
		try
		{
			empList.put(emp.getEmpId(), emp);
			return true;
		} catch( NullPointerException e ) {
			return false;
		}
	}
	@Override
	public Employee findEmployee(int id) {
		try
		{
			if(empList.get(id)!=null)
			{
				return empList.get(id);
			}
			else 
			{
				System.out.println("No Employee Added for "+id);
				return null;
			}
		} catch( NullPointerException e ) {
			return null;
		}
	}



	@Override
	public Collection<Employee> getAllEmployee() {
		return empList.values();
	}
	
	
}
