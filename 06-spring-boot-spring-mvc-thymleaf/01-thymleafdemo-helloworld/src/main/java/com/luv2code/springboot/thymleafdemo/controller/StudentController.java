package com.luv2code.springboot.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StudentController {
	
	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {
		
		
		
		return "student-form";
	}
	
}
