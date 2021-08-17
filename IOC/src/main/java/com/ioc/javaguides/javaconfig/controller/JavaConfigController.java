package com.ioc.javaguides.javaconfig.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ioc.javaguides.javaconfig.bean.HelloWorld;

public class JavaConfigController {

	public static void main(String[] args) {

		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);*/
		HelloWorld helloWorld=(HelloWorld)factory.getBean("helloWorld");
		//HelloWorld helloWorld=(HelloWorld)context.getBean("helloWorld");
		System.out.println(helloWorld.getMessage());
		//context.close();
		//context.close();
	}
}
