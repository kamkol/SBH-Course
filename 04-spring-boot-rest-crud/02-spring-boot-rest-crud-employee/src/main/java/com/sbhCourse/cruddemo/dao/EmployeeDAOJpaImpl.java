package com.sbhCourse.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sbhCourse.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	//define field for enity_manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		//create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get employee
		Employee thEmployee = entityManager.find(Employee.class, theId);
		//return the employee
		return thEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		//save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//return the dbEmployee
		return dbEmployee;
	}

	@Override
	public void deleteById(int theId) {
		//find employee by id
		Employee theEmployee =entityManager.find(Employee.class, theId);
		//remove employee
		entityManager.remove(theEmployee);
		
	}
	
	

}
