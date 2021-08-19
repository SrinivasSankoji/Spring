package com.ioc.javaguides.di.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ioc.javaguides.di.service"})
public class DIConfiguration {

}
