package com.jio.ngo.dao;

import com.jio.ngo.model.DatabaseLoginInfo;

public interface StringDao 
{
   DatabaseLoginInfo addDbDetails(DatabaseLoginInfo databaseLoginInfo);
   void updateDbDetails(DatabaseLoginInfo databaseLoginInfo);
   DatabaseLoginInfo getDbDetails(DatabaseLoginInfo databaseLoginInfo);
   void deleteDbDetails(DatabaseLoginInfo databaseLoginInfo) ;
}

