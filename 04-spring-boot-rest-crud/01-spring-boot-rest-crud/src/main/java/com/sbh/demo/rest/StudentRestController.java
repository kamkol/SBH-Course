package com.sbh.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbh.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct to load the student data
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Josh", "Rossi"));
		theStudents.add(new Student("Gaby", "Smith"));
	}
	
	//define endpoint for "/student" return a list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
}
