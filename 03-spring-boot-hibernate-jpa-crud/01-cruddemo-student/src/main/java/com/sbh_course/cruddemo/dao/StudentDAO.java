package com.sbh_course.cruddemo.dao;

import java.util.List;

import com.sbh_course.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student student);
	
	Student findById (Integer id);

	List<Student> findAll();
	
}
