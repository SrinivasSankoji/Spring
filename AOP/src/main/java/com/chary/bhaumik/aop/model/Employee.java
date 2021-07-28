package com.chary.bhaumik.aop.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String empId;
	private String name;

}
