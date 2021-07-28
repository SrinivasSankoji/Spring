package com.jio.ngo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.jio.ngo.model.DatabaseLoginInfo;
import com.jio.ngo.service.StringService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/nextgenops")
@Slf4j
public class StringController 
{
	@Autowired
	private StringService stringService;
	
	@RequestMapping(value="/addDbDetails",method=RequestMethod.POST)
	public DatabaseLoginInfo  addDbDetails(@RequestBody DatabaseLoginInfo databaseLoginInfo,
			HttpServletRequest request)  
	{
		String contextpath=request.getContextPath();
		String path = (String) request.getAttribute(
		HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		log.info("addDbDetails() in StringController with Context Path : "+contextpath); 
		log.info("addDbDetails() in StringController with URL : "+path); 
		return stringService.addDbDetails(databaseLoginInfo);
	}

}

