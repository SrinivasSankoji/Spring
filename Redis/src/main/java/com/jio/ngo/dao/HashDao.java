package com.jio.ngo.dao;

import com.jio.ngo.model.DatabaseLoginInfo;

public interface HashDao 
{
   DatabaseLoginInfo addDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo);
   void updateDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo);
   DatabaseLoginInfo getDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo);
   void deleteDbDetailsForHash(DatabaseLoginInfo databaseLoginInfo) ;

}
