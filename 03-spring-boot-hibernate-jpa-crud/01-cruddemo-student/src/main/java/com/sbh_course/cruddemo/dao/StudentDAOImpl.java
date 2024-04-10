package com.sbh_course.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.sbh_course.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		//create query
		TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student", Student.class);
		
		//return query results
		return typedQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		//create query
		TypedQuery<Student> typedQuery = entityManager.createQuery(
							"FROM Student WHERE lastName=:theData", Student.class);

		//set query parameters
		typedQuery.setParameter("theData", theLastName);
		
		//return query
		return typedQuery.getResultList();
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		entityManager.merge(student);
	}

}
