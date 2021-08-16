package com.ioc.dzone.service;

public class StrutsQuizMaster implements QuizMaster {

	@Override
	public String popquestion() {
		return "Are you new to Struts ?";
	}
}
