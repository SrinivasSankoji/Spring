package com.ioc.javaguides.dependson.model;

import org.springframework.beans.factory.annotation.Autowired;

public class FirstBean {

	
	@Autowired
	private SecondBean secondBean;
	@Autowired
	private ThirdBean thirdBean;
	
	public FirstBean() {
		super();
		System.out.println("First Bean via Default Constructor");
	}

	public void display() {
        System.out.println("First Bean method called");
    }
	
	public void populateBeans()
	{
		secondBean.display();
		thirdBean.display();
	}
	
}
