package com.sbh_course.cruddemo;

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
		};
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
