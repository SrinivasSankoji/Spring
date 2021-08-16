package com.ioc.javaguides.javaconfig.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ioc.javaguides.javaconfig.bean.HelloWorld;

public class JavaConfigController {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);*/
		HelloWorld helloWorld=(HelloWorld)context.getBean("helloWorld");
		System.out.println(helloWorld.getMessage());
		//context.close();
		//context.close();
	}
}
