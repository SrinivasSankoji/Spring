package com.ioc.javaguides.dependson.model;

public class SecondBean {

	public SecondBean() {
		super();
		System.out.println("Second Bean via Default Constructor");
	}

	public void display() {
        System.out.println("Second Bean method called");
    }
}
