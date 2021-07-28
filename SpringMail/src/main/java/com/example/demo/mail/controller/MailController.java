package com.example.demo.mail.controller;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.model.Email;
import com.example.demo.mail.model.Feedback;

@RestController
@RequestMapping("/mail")
public class MailController 
{

	@Autowired
	Email email;

	@PostMapping("/testing")
	public void sendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) 
		{
			throw new ValidationException("Feedback is not valid");
		}

		// Create a mail sender
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.email.getHost());
		mailSender.setPort(this.email.getPort());
		mailSender.setUsername(this.email.getUsername());
		mailSender.setPassword(this.email.getPassword());

		// Create an email instance
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(feedback.getEmail());
		mailMessage.setTo("srinivas@feedback.com");
		mailMessage.setSubject("New feedback from " + feedback.getName());
		mailMessage.setText(feedback.getFeedback());

		// Send mail
		mailSender.send(mailMessage);
	}

}
