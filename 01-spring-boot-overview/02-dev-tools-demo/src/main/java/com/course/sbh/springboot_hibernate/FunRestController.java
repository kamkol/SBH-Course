package com.course.sbh.springboot_hibernate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world!";
	}
	
//	expose new endopint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Hello your daily workout!";
	}
}
