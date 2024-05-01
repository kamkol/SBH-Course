package com.sbh.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbh.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	//define endpoint for "/student" return a list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Josh", "Rossi"));
		theStudents.add(new Student("Gaby", "Smith"));
		return theStudents;
	}
	
}
