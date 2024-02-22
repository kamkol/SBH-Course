package com.course.sbh.springboot_hibernate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello world!";
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Hello your daily workout!";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "TOday is your lucky day!";
	}
}
