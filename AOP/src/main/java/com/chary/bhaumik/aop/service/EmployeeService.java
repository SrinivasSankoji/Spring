package com.chary.bhaumik.aop.service;

import java.util.List;

import com.chary.bhaumik.aop.model.Employee;

public interface EmployeeService 
{
	Employee createEmployee(String name, String empId);
	
	String deleteEmployee(String empId);
	
	List<Employee> getEmployeeDetails();
}
