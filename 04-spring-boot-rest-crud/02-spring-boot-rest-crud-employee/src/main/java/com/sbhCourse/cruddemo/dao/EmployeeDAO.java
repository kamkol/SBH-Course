package com.sbhCourse.cruddemo.dao;

import java.util.List;
import com.sbhCourse.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();

}
