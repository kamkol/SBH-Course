package com.luv2code.springboot.thymleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.luv2code.springboot.thymleafdemo.model.Student;


@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${favoriteProgrammingLanguage}")
	private List<String> favoriteProgrammingLanguage;
	
	@Value("${favoriteSystems}")
	private List<String> favoriteSystems;
	
	
	@GetMapping("/showStudentForm")
	public String showForm(Model theModel) {
		
		//create a student object
		Student theStudent = new Student();
		
		//add student object to the model
		theModel.addAttribute("student", theStudent);
		
		//add the list of countries to the model
		theModel.addAttribute("countries", countries);
		
		//add list of favorite language to the model
		theModel.addAttribute("favoriteProgrammingLanguage", favoriteProgrammingLanguage);
		
		//add list of favorite systems to the model
		theModel.addAttribute("favoriteSystems", favoriteSystems);
		
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confrimation";
	}
	
}