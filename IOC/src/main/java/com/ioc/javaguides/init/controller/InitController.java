package com.ioc.javaguides.init.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ioc.javaguides.init.configuration.InitConfiguration;

public class InitController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitConfiguration.class);
		context.close();
	}
}
