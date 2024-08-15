package com.sbhCourse.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbhCourse.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	

}
