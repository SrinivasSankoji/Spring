package com.ioc.dzone.service;

public class SpringQuizMaster implements QuizMaster {

	@Override
	public String popquestion() {
		return "Are you new to Spring ?";
	}

}
