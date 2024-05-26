package com.sbhCourse.cruddemo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sbhCourse.cruddemo.dao.EmployeeDAO;
import com.sbhCourse.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}
	
	
}
