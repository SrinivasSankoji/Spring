package com.jio.ngo.service;

import com.jio.ngo.model.DatabaseLoginInfo;

public interface StringService 
{
   DatabaseLoginInfo addDbDetails(DatabaseLoginInfo databaseLoginInfo);
   void updateDbDetails(DatabaseLoginInfo databaseLoginInfo);
   DatabaseLoginInfo getDbDetails(DatabaseLoginInfo databaseLoginInfo);
   void deleteDbDetails(DatabaseLoginInfo databaseLoginInfo) ;
}

