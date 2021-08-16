package com.ioc.dzone.service;

public class QuizMasterService {

	/**
	 * Traditional Way of Injecting the Dependencies
	 */
	//private QuizMaster quizMaster = new SpringQuizMaster();
	
	QuizMaster quizMaster;
	
	/**
	 * Injecting the Dependencies using Setter Injection
	 */
	public void setQuizMaster(QuizMaster quizMaster) {
		this.quizMaster = quizMaster;
	}

	public void askquestion() {
		System.out.println(quizMaster.popquestion());
	}
}
