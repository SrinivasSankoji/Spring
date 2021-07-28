package com.jio.ngo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.jio.ngo.model.Customer;
import com.jio.ngo.model.Employee;
import com.jio.ngo.service.RedisStoreService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/nextgenops")
@Slf4j
public class RedisStoreController 
{
	@Autowired
	private RedisStoreService redisStoreService;
	
	Employee employee=null;
	Object result=null;
	String sessionid=null;
	
	/**
	 * Redis Template
	 */
	@RequestMapping(value="/redis/{name}",method=RequestMethod.POST)
	public Object  getNameInRedis(@PathVariable("name") String name,
			HttpServletRequest request)  
	{
		String contextpath=request.getContextPath();
		String path = (String) request.getAttribute(
		HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("getNameInRedis() in RedisStoreController with Context Path : "+contextpath); 
		log.info("getNameInRedis() in RedisStoreController with URL : "+path); 
		employee=new Employee();
		employee.setId("23");
		employee.setName("Bhaumik");
		employee.setAge(1);
		result=redisStoreService.save(employee);
		return result;
	}
	
	/**
	 * String Redis Template
	 */
	@RequestMapping(value="/stringredis/{student}",method=RequestMethod.POST)
	public Object  getStringNameInRedis(@PathVariable("student") String student,
			HttpServletRequest request)  
	{
		String contextpath=request.getContextPath();
		String path = (String) request.getAttribute(
		HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("getStringNameInRedis() in RedisStoreController with Context Path : "+contextpath); 
		log.info("getStringNameInRedis() in RedisStoreController with URL : "+path); 
		employee=new Employee();
		employee.setId("27");
		employee.setName("Nandini");
		employee.setAge(25);
		result=redisStoreService.persist(employee);
		return result;
	}
	
	/**
	 * Hash Redis Template
	 */
	@RequestMapping(value="/hashredis/{name}",method=RequestMethod.POST)
	public Object  getHashNameInRedis(@PathVariable("name") String name,
			HttpServletRequest request)  
	{
		sessionid=request.getSession().getId();
		String contextpath=request.getContextPath();
		String path = (String) request.getAttribute(
		HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("getHashNameInRedis() in RedisStoreController with Context Path : "+contextpath); 
		log.info("getHashNameInRedis() in RedisStoreController with URL : "+path); 
		log.info("getHashNameInRedis() in RedisStoreController with Session Id : "+sessionid);
		Map<String, String> employee = new HashMap<>();
		employee.put("name", "Bhaumik");
		employee.put("age", "01");
		employee.put("id", "23");
		result=redisStoreService.find(sessionid,employee);
		return result;
	}
	
	
	/**
	 * HashOperations Using  RedisTemplate
	 */
	@RequestMapping(value="/hashOperations",method=RequestMethod.POST)
	public Object  saveCustomerUsingHashOperations(@RequestBody Customer customer,
			HttpServletRequest request)  
	{
		String contextpath=request.getContextPath();
		String path = (String) request.getAttribute(
		HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("saveCustomerUsingHashOperations() in RedisStoreController with Context Path : "+contextpath); 
		log.info("saveCustomerUsingHashOperations() in RedisStoreController with URL : "+path); 
		redisStoreService.save(customer);
		return result;
	}
}

