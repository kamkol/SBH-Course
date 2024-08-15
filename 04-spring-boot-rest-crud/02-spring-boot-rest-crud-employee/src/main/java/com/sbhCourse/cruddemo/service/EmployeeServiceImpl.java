package com.sbhCourse.cruddemo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sbhCourse.cruddemo.dao.EmployeeDAO;
import com.sbhCourse.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

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

	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public Employee save(Employee theEmployee) {
		return employeeDAO.save(theEmployee);
	}
  
	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}
	
	
}
