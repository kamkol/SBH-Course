package com.sbh_course.cruddemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sbh_course.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO{

	//define field for entity manager
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	//implement save method
	@Override
	@Transactional
	public void save(Student student) {
		// TODO Auto-generated method stub
		entityManager.persist(student);
	}

}
