package com.sbh_course.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@PostConstruct
	public void doMyStartup() {
		System.out.println("In do myStartUp(): " + getClass().getSimpleName());
	}
	
	@PreDestroy
	public void doMyCleanUp() {
		System.out.println("In do myCleanUp(): " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {	
		return "Practice fast bowling for 15 minutes";
	}

}
