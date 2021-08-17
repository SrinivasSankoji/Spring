package com.ioc.javaguides.dependson.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.ioc.javaguides.dependson.model.FirstBean;
import com.ioc.javaguides.dependson.model.SecondBean;
import com.ioc.javaguides.dependson.model.ThirdBean;

@Configuration
public class DependsOnConfiguration {

	@Bean
	@DependsOn(value = { "secondBean","thirdBean"})
	public FirstBean firstBean() {
		return new FirstBean();
	}

	@Bean
	public SecondBean secondBean() {
		return new SecondBean();
	}

	@Bean
	public ThirdBean thirdBean() {
		return new ThirdBean();
	}
}
