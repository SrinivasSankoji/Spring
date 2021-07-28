package com.jio.ngo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.ngo.dao.HashDao;
import com.jio.ngo.model.DatabaseLoginInfo;

@Service
public class HashServiceImpl implements HashService
{
	@Autowired
	private HashDao hashDao;

	@Override
	public DatabaseLoginInfo addDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) 
	{
		return hashDao.addDbDetailsForHash(databaseLoginInfo);
	}

	@Override
	public void updateDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) 
	{
		hashDao.updateDbDetailsForHash(databaseLoginInfo);
	}

	@Override
	public DatabaseLoginInfo getDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo)
	{
		return hashDao.getDbDetailsForHash(databaseLoginInfo);
	}

	@Override
	public void deleteDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) 
	{
		hashDao.deleteDbDetailsForHash(databaseLoginInfo);
	}

}

