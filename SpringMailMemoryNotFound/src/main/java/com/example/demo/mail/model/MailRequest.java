package com.example.demo.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MailRequest implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String to;
	private String from;
	private String subject;

}
