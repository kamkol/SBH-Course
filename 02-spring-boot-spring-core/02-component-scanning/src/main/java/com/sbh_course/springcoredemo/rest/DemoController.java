package com.sbh_course.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbh_course.springcoredemo.common.Coach;

@RestController
public class DemoController {
	
	private Coach myCoach;
	private Coach anotherCoach;
	
	@Autowired
	public DemoController(
			@Qualifier("cricketCoach") Coach theCoach,
			@Qualifier("cricketCoach") Coach theAnotherCoach) {
		System.out.println("In constructor: " + getClass().getSimpleName());
		myCoach = theCoach;
		anotherCoach = theAnotherCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
