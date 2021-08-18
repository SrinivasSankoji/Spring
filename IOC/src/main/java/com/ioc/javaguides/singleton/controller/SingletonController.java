package com.ioc.javaguides.singleton.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ioc.javaguides.singleton.configuration.SingletonConfiguration;
import com.ioc.javaguides.singleton.model.UserService;

public class SingletonController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SingletonConfiguration.class);
		UserService service=context.getBean(UserService.class);
		service.setName("Singleton Scope");
		System.out.println(service.getName());
		
		UserService service1=context.getBean(UserService.class);
		System.out.println(service1.getName());
		context.close();
	}
}
