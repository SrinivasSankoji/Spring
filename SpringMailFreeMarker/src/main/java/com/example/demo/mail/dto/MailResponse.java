package com.example.demo.mail.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String message;
	private boolean status;

}
