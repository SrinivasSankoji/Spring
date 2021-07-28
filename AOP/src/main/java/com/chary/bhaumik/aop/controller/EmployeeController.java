package com.chary.bhaumik.aop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chary.bhaumik.aop.model.Employee;
import com.chary.bhaumik.aop.service.EmployeeService;

@RestController
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/add/employee")
	public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

		return employeeService.createEmployee(name, empId);

	}

	@GetMapping("/remove/employee")
	public String removeEmployee( @RequestParam("empId") String empId)
	{
		return employeeService.deleteEmployee(empId);
	}
	
	@GetMapping("/get/employeeDetails")
	public List<Employee> getEmployeeDetails()
	{
		return employeeService.getEmployeeDetails();
	}

}
