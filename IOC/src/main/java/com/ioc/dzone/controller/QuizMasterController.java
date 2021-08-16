package com.ioc.dzone.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ioc.dzone.service.QuizMasterService;

public class QuizMasterController {

	public static void main(String[] args) {
		/**
		 * Traditional Way
		 */
		//QuizMasterService quizmasterservice = new QuizMasterService();
        //quizmasterservice.askquestion();
		
		/**
		 * Container creating the Dependencies
		 */
		ApplicationContext  context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
		QuizMasterService quizmasterservice = context.getBean(QuizMasterService.class);
		quizmasterservice.askquestion();
    }
}
