package com.ioc.javaguides.di.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ioc.javaguides.di.service.MessageService;
import com.ioc.javaguides.javaconfig.configuration.ApplicationConfiguration;

public class DependencyInjectionController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);
		//ConstructorBasedInjection bean=context.getBean(ConstructorBasedInjection.class);
		//SetterBasedInjection bean=context.getBean(SetterBasedInjection.class);
		MessageService bean=context.getBean(MessageService.class); // @Primary Annotation Example
		bean.sendMessage("Setter Based Injection Example");
		context.close();
	}
}
