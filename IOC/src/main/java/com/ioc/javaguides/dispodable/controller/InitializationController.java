package com.ioc.javaguides.dispodable.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ioc.javaguides.dispodable.configuration.InitializeConfiguration;

public class InitializationController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				InitializeConfiguration.class);
		context.close();
	}

}
