package com.course.sbh.springboot_hibernate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
//	//inject properties for: book.name & author.name
//	@Value("${author.name}")
//	private String authorName;
//
//	@Value("${book.name}")
//	private String bookName;
//	
//	//expose new endpoint for "author and book"
//	@GetMapping("/authorbookinfo")
//	public String getAuthorInfo() {
//		return "Author name: " + authorName + ", book name: " + bookName;
//	}
	
	
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
		return "Lucky day!";
	}
	
	@GetMapping("/fruit")
	public String getDailyFruits() {
		return "It's time for ananas!";
	}
}
