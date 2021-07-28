package com.jio.ngo.dao;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jio.ngo.model.DatabaseLoginInfo;

@Repository
@Transactional
public class HashDaoImpl implements HashDao
{
	
	private static final String KEY = "databaseLoginInfo";
	
   @Resource(name="redisTemplate")
   private HashOperations<String, String, Object> opsForHash;

	@Override
	public DatabaseLoginInfo addDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) 
	{
		 opsForHash.putIfAbsent(KEY, databaseLoginInfo.getDomainId()+"-"+databaseLoginInfo.getSid(), databaseLoginInfo);
		 return getDbDetailsForHash(databaseLoginInfo);
	}

	@Override
	public void updateDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) 
	{
		
	}

	@Override
	public DatabaseLoginInfo getDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) 
	{
		return (DatabaseLoginInfo) opsForHash.get(KEY, databaseLoginInfo.getDomainId()+"-"+databaseLoginInfo.getSid());
	}

	@Override
	public void deleteDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) 
	{
		opsForHash.delete(KEY, databaseLoginInfo.getDomainId()+"-"+databaseLoginInfo.getSid());
	}

}

