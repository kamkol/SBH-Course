package com.sbh_course.springcoredemo.common;

public class SwimCoach implements Coach{
	
	public SwimCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());;
	}

	@Override
	public String getDailyWorkout() {
		return "Swoim 1000 meters!";
	}

}
