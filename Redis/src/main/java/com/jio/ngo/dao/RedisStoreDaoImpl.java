package com.jio.ngo.dao;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jio.ngo.model.Customer;
import com.jio.ngo.model.Employee;

@Repository
@Transactional
public class RedisStoreDaoImpl implements RedisStoreDao
{
	
	private static final String KEY = "Customer";
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private RedisTemplate<String, Object> stringRedisTemplate;
	
	@Resource(name="redisTemplate")
	private HashOperations<String, String, Customer> hashOperations;
	
	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public Object save(Employee employee) 
	{
	  ValueOperations<String, Object> values = redisTemplate.opsForValue();
	  values.set("01", "Nandini");
	  System.out.println("Employee added: "+values.get("01"));
	  return values.get("01");
	}
	
	@Override
	public Object persist(Employee employee) 
	{
	  ValueOperations<String, Object> values = stringRedisTemplate.opsForValue();
	  values.set("Nandini", "Bhaumik");
	  System.out.println("Employee added: "+values.get("Nandini"));
	  return values.get("Nandini");
	}

	@Override
	public Map<String, String> find(String sessionid,Map<String, String> employee) 
	{
		HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
		hashOperations.putAll(sessionid, employee);
		System.out.println("Get emp joe details: " + hashOperations.entries(sessionid));
		Map<String, String> result=hashOperations.entries(sessionid);
		return result; 

	}

	@Override
	public void save(Customer customer)
	{
		hashOperations.put(KEY, customer.getId(), customer);
	}

}

