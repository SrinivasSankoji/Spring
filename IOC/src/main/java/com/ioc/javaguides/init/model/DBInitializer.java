package com.ioc.javaguides.init.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBInitializer {

	 private List < Employee > listOfEmployees = new ArrayList < > ();

	    public void init() {
	        Employee Employee = new Employee(1, "Employee");
	        Employee Employee1 = new Employee(2, "Admin");
	        Employee Employee2 = new Employee(3, "SuperAdmin");

	        listOfEmployees.add(Employee);
	        listOfEmployees.add(Employee1);
	        listOfEmployees.add(Employee2);
	        System.out.println("-----------List of Employees added in init() method ------------");
	        for (Iterator < Employee > iterator = listOfEmployees.iterator(); iterator.hasNext();) {
	            Employee Employee3 = (Employee) iterator.next();
	            System.out.println(Employee3.toString());
	        }
	        // save to database

	    }

	    public void destroy() {
	        // Delete from database
	        listOfEmployees.clear();
	        System.out.println("-----------After of Employees removed from List in destroy() method ------------");
	        System.out.println("End of destroy()  method");
	    }
}
