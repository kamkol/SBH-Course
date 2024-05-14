package com.sbh.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		theStudents.add(new Student("Warclaw", "Fang"));
	}
	
	//define endpoint for "/student" return a list of student
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	//define endpoint or "/students/{studentId}" - return student index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//check the studentId again list size
		if ((studentId>= theStudents.size()) || (studentId<0)) {
			throw new StudentNotFoundExecption("Student id not found: " + studentId);
		}
		//get student index from the list
		return theStudents.get(studentId);
	}
	
	//add an exception handler using @ExceptionHanlder
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundExecption exc) {
		
		//create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return ResponseEntity
		
		return null;
	}
	
	
	
	
}
