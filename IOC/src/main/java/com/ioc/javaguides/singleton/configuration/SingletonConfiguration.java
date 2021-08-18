package com.ioc.javaguides.singleton.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ioc.javaguides.singleton.model.UserService;

@Configuration
@ComponentScan("com.ioc.javaguides.singleton.model")
public class SingletonConfiguration {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public UserService userService()
	{
		return new UserService();	
	}
}
