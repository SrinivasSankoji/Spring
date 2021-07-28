package com.jio.ngo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Component
public class Employee implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String id;
    private String name;
    private Integer age;

}

