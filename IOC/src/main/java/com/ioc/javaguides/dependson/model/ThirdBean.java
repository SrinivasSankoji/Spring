package com.ioc.javaguides.dependson.model;

public class ThirdBean {

	public ThirdBean() {
		super();
		System.out.println("Third Bean via Default Constructor");
	}

	public void display() {
        System.out.println("Third Bean method called");
    }
}
