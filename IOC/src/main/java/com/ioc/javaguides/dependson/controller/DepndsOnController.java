package com.ioc.javaguides.dependson.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ioc.javaguides.dependson.configuration.DependsOnConfiguration;
import com.ioc.javaguides.dependson.model.FirstBean;

public class DepndsOnController {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
		FirstBean firstBean=context.getBean(FirstBean.class);
		firstBean.populateBeans();
		context.close();
	}
}
