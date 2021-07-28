package com.chary.bhaumik.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chary.bhaumik.aop.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AOPTest 
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeService employeeService;
	
	//@Test
	public void addEmployeeTest() 
	{
		logger.info("addEmployeeTest() Execution Started");
		employeeService.createEmployee("Bhaumik Chary", "27");
		logger.info("addEmployeeTest() Execution Ended");
	}
	
	@Test
	public void getEmployeeDetailsTest() 
	{
		employeeService.getEmployeeDetails();
	}

}
