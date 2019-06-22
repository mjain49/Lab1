package com.cg.eis.service;

import java.util.Collection;

import com.cg.eis.bean.Employee;
import com.cg.eis.dao.EmployeeDAOImpl;

public class EmpService implements EmpServiceInterface {

	EmployeeDAOImpl dao=new EmployeeDAOImpl();
	
	@Override
	public boolean addEmployee(Employee emp){
		try
		{
			// empList.put(emp.getEmpId(), emp);
			double sal=emp.getEmpSalary();
			String desg=emp.getEmpDesg();
			String scheme=generateScheme(sal,desg);
			
			if(scheme !=null)
			{
				emp.setEmpScheme(scheme);
			}
			else
			{
				System.out.println("Unsuccessful......");
				return false;
			}
			return dao.addEmployee(emp);
			
		} catch( NullPointerException e ) {
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(emp);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(emp);
	}

	@Override
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.findEmployee(id);
	}

	private String generateScheme(double sal,String desg)
	{
		if((sal>=5000.00 && sal<20000.00)&&(desg.equalsIgnoreCase("System Associate"))){
			return "Scheme C";
		}else if((sal>=20000.00 && sal<40000.00)&&(desg.equalsIgnoreCase("Programmer"))){
				return "Scheme B";
		}else if((sal>=40000.00)&&(desg.equalsIgnoreCase("Manager"))){
			return "Scheme A";
		}else if((sal<5000.00)&&(desg.equalsIgnoreCase("Clerk"))){
			return "No Scheme";
		}else
			{
			System.out.println("Salary and Desg Mismatch");
			return null;
			}
	}
	
	
	
	public void printStatement(Employee ob) {
		 
		 System.out.println("========================================");
		 System.out.println("Statement for Employee Id.: "+ob.getEmpId());

		 System.out.println("Employee Name: "+ob.getEmpName());
		 System.out.println("Salary is => "+ob.getEmpSalary());
		 System.out.println("Designation is => "+ob.getEmpDesg());
		 System.out.println("Scheme -->>"+ob.getEmpScheme());
		 
		 System.out.println("========================================");
		 
	 }

	@Override
	public Collection<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}


}
