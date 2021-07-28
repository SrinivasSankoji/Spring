package com.jio.ngo.service;

import com.jio.ngo.model.DatabaseLoginInfo;

public interface HashService 
{
	
   DatabaseLoginInfo addDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo);
   void updateDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo);
   DatabaseLoginInfo getDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo);
   void deleteDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) ;

}

