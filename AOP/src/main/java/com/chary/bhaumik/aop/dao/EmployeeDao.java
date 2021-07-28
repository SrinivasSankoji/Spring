package com.chary.bhaumik.aop.dao;

import java.util.List;

import com.chary.bhaumik.aop.model.Employee;

public interface EmployeeDao 
{
	Employee createEmployee(String name, String empId);
	
	String deleteEmployee(String empId);
	
	List<Employee> getEmployeeDetails();
}
