package com.jio.ngo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jio.ngo.model.DatabaseLoginInfo;

@Repository
@Transactional
public class StringDaoImpl implements StringDao
{
	
	@Autowired
	private RedisTemplate<String, Object> stringRedisTemplate;
	
	@Override
	public DatabaseLoginInfo addDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		stringRedisTemplate.opsForValue().setIfAbsent
		(databaseLoginInfo.getDomainId()+"-"+databaseLoginInfo.getSid(), databaseLoginInfo);
		return getDbDetails(databaseLoginInfo);
	}

	@Override
	public void updateDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		stringRedisTemplate.opsForValue().set
		(databaseLoginInfo.getDomainId()+"-"+databaseLoginInfo.getSid(), databaseLoginInfo);
	}

	@Override
	public DatabaseLoginInfo getDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		return (DatabaseLoginInfo) stringRedisTemplate.opsForValue().get(databaseLoginInfo.getDomainId()+"-"+databaseLoginInfo.getSid());
	}

	@Override
	public void deleteDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		stringRedisTemplate.delete(databaseLoginInfo.getDomainId()+"-"+databaseLoginInfo.getSid());
	}

}

