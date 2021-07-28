package com.example.demo.mail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.configuration.SmtpMailSender;

@RestController
public class GmailController 
{
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping("/send-mail")
	public void sendMail() throws MessagingException 
	{
		smtpMailSender.send("srinivaschary.chary@gmail.com", "Test mail from Spring", "How Are You");
	}

}
