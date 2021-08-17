package com.ioc.javaguides.di.service;

import org.springframework.stereotype.Service;

@Service("TwitterService")
public class TwitterService implements MessageService{

	@Override
	public void sendMessage(String message) {
		System.out.println("Twitter "+message);
	}

}
