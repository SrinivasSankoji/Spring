package com.example.demo.mail.controller;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mail.model.Mail;
import com.example.demo.mail.model.MailRequest;
import com.example.demo.mail.service.MailService;

@RestController
public class MailController 
{
	@Autowired
	MailService mailService;
	
	@PostMapping("/sendingEmail")
	public Mail sendEmail(@RequestBody MailRequest request) throws MessagingException 
	{
		Mail mail = new Mail();
        mail.setFrom("no-reply@memorynotfound.com");
        mail.setTo("info@memorynotfound.com");
        mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

        Map<String,Object> model = new HashMap<String,Object>();
        model.put("name", "Memorynotfound.com");
        model.put("location", "Belgium");
        model.put("signature", "https://memorynotfound.com");
        mail.setModel(model);

        return mailService.sendMail(mail);
	}

}
