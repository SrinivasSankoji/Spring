package com.example.demo.mail.service;

import javax.mail.MessagingException;

import com.example.demo.mail.model.Mail;

public interface MailService 
{
	Mail sendMail(Mail mail) throws MessagingException;

}
