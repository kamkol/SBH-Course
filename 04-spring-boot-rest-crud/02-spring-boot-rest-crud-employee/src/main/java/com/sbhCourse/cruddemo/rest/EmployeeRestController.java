package com.sbhCourse.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sbhCourse.cruddemo.dao.EmployeeDAO;
import com.sbhCourse.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;

	//quick and dirty: inject employee DAO (use constructor injection)
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	//expose "/employees" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}
