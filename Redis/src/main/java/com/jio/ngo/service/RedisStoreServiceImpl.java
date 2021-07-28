package com.jio.ngo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.ngo.dao.RedisStoreDao;
import com.jio.ngo.model.Customer;
import com.jio.ngo.model.Employee;

@Service
public class RedisStoreServiceImpl implements RedisStoreService
{
	@Autowired
	private RedisStoreDao redisStoreDao;

	@Override
	public Object save(Employee employee) 
	{
		return redisStoreDao.save(employee);
	}
	
	@Override
	public Object persist(Employee employee) 
	{
		return redisStoreDao.persist(employee);
	}

	@Override
	public Map<String, String> find(String sessionid,Map<String, String> employee) 
	{
		return redisStoreDao.find(sessionid,employee);
	}

	@Override
	public void save(Customer customer) 
	{
		redisStoreDao.save(customer);
	}

}

