package com.ioc.javaguides.di.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("SMSService")
@Primary
public class SMSService implements MessageService{

	@Override
	public void sendMessage(String message) {
		System.out.println("SMS "+message);
	}

}
