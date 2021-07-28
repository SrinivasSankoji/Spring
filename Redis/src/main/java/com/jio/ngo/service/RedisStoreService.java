package com.jio.ngo.service;

import java.util.Map;

import com.jio.ngo.model.Customer;
import com.jio.ngo.model.Employee;

public interface RedisStoreService 
{
	Object save(Employee employee);
	
	Object persist(Employee employee);
	
	Map<String, String> find(String sessionid,Map<String, String> employee);
	
	void save(Customer customer);

}
