package com.chary.bhaumik.aop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.bhaumik.aop.dao.EmployeeDao;
import com.chary.bhaumik.aop.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	EmployeeDao employeeDao;
	 
	@Override
	public Employee createEmployee(String name, String empId)
	{
		return employeeDao.createEmployee(name, empId);
	}

	@Override
	public String deleteEmployee(String empId) 
	{
		return employeeDao.deleteEmployee(empId);
	}

	@Override
	public List<Employee> getEmployeeDetails() 
	{
		return employeeDao.getEmployeeDetails();
	}

}
