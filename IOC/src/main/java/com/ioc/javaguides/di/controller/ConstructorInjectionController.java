package com.ioc.javaguides.di.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ioc.javaguides.di.service.SetterBasedInjection;
import com.ioc.javaguides.javaconfig.configuration.ApplicationConfiguration;

public class ConstructorInjectionController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);
		//ConstructorBasedInjection bean=context.getBean(ConstructorBasedInjection.class);
		SetterBasedInjection bean=context.getBean(SetterBasedInjection.class);
		bean.processMessage("Setter Based Injection Example");
		context.close();
	}
}
