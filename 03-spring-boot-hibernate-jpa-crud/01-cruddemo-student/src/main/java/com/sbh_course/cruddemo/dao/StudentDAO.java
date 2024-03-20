package com.sbh_course.cruddemo.dao;

import com.sbh_course.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student student);
	
	Student findById (Integer id);

}
