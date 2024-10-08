package com.sbh_course.cruddemo;

import java.util.Iterator;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.sbh_course.cruddemo.dao.StudentDAO;
import com.sbh_course.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAll(studentDAO);
		};
	}


	private void deleteAll(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Deleting all students.");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting stundet with id: " + studentId);
		Student newStudent = studentDAO.findById(studentId);
		
		//change first name to "Jonathan"
		newStudent.setFirstName("Jonathan");
		studentDAO.update(newStudent);
		
		//display updated student
		System.out.println("Updated student: " + newStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Crystal");
	
		//display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> students = studentDAO.findAll();
		
		//display all students
		for(Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object.");
		Student tempStudent = new Student("Brandon", "Sanderson", "brandon.sanderson@yellow.com");
		
		//save the student
		System.out.println("Saving student");
		studentDAO.save(tempStudent);
				
		//display id of student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generate id: " + theId);

		//retrieve student base on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);
		
		//display student
		System.out.println("Found the student: " + myStudent);
	}

	
	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student objects.");
		Student tempStudent1 = new Student("John", "Crystal", "john.crystal@yellow.com");
		Student tempStudent2 = new Student("Barry", "Red", "barry.red@yellow.com");
		Student tempStudent3 = new Student("Jaruzelim", "Griko", "jaruzelim.griko@yellow.com");
		
		//save students objects
		System.out.println("Saving students.");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
		//display id of students
		System.out.println("Saved student. Generated id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated id: " + tempStudent3.getId());

	}
	

	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object: ");
		Student tempStudent = new Student("Paul", "Doe", "paul.doe@yellow.com");
		
		//save student object
		System.out.println("Saving student: ");
		studentDAO.save(tempStudent);
		
		//display id of saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
