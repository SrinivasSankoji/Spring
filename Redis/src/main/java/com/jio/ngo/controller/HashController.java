package com.jio.ngo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.jio.ngo.model.DatabaseLoginInfo;
import com.jio.ngo.service.HashService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/nextgenops")
@Slf4j
public class HashController 
{
	
	@Autowired
	private HashService hashService;
	
	@RequestMapping(value="/addDbDetailsForHash",method=RequestMethod.POST)
	public DatabaseLoginInfo  addDbDetailsForHash(@RequestBody DatabaseLoginInfo databaseLoginInfo,
			HttpServletRequest request)  
	{
		String contextpath=request.getContextPath();
		String path = (String) request.getAttribute(
		HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("addDbDetailsForHash() in HashController with Context Path : "+contextpath); 
		log.info("addDbDetailsForHash() in HashController with URL : "+path); 
		return hashService.addDbDetailsForHash(databaseLoginInfo);
	}
	
	@RequestMapping(value="/deleteDbDetailsForHash",method=RequestMethod.POST)
	public void  deleteDbDetailsForHash(@RequestBody DatabaseLoginInfo databaseLoginInfo,
			HttpServletRequest request)  
	{
		String contextpath=request.getContextPath();
		String path = (String) request.getAttribute(
		HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("deleteDbDetailsForHash() in HashController with Context Path : "+contextpath); 
		log.info("deleteDbDetailsForHash() in HashController with URL : "+path); 
		hashService.deleteDbDetailsForHash(databaseLoginInfo);
	}

}

