package com.chary.bhaumik.aop.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chary.bhaumik.aop.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{

	@Override
	public Employee createEmployee(String name, String empId) 
	{
		Employee emp = new Employee();
		emp.setName(name);
		emp.setEmpId(empId);
		return emp;
	}

	@Override
	public String deleteEmployee(String empId) 
	{
		return "Employee removed";
	}

	@Override
	public List<Employee> getEmployeeDetails() 
	{
		//throw new RuntimeException("User Defined Exception");
		return Arrays.asList(
		new Employee("23","Bhaumik Chary"),
		new Employee("27","Nandini Sankoji"),
		new Employee("22","Srinivas Chary"));
	}
	

}
