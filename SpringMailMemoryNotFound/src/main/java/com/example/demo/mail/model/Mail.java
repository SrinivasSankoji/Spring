package com.example.demo.mail.model;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

@Data
public class Mail implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String from;
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> model;

}
