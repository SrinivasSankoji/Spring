package com.jio.ngo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jio.ngo.dao.StringDao;
import com.jio.ngo.model.DatabaseLoginInfo;

@Service
public class StringServiceImpl implements StringService
{
	@Autowired
	private StringDao stringDao;

	@Override
	public DatabaseLoginInfo addDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		return stringDao.addDbDetails(databaseLoginInfo);
	}

	@Override
	public void updateDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		stringDao.updateDbDetails(databaseLoginInfo);
	}

	@Override
	public DatabaseLoginInfo getDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		return stringDao.getDbDetails(databaseLoginInfo);
	}

	@Override
	public void deleteDbDetails(DatabaseLoginInfo databaseLoginInfo) 
	{
		stringDao.deleteDbDetails(databaseLoginInfo);
	}

}

