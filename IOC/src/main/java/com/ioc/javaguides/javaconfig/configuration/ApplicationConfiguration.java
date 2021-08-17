package com.ioc.javaguides.javaconfig.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ioc.javaguides.javaconfig.bean.HelloWorld;

@Configuration
@ComponentScan("com.ioc.javaguides.di.service")
public class ApplicationConfiguration {

	@Bean
	public HelloWorld helloWorld() {
		HelloWorld world = new HelloWorld();
		world.setMessage("Success");
		return world;
	}
}
