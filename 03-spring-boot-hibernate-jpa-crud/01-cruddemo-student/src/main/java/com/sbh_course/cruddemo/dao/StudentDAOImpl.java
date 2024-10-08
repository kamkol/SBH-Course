package com.sbh_course.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		this.entityManager = entityManager;
	}
	
	//implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		//create query
		TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student", Student.class);
		
		//return query results
		return typedQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		//create query
		TypedQuery<Student> typedQuery = entityManager.createQuery(
							"FROM Student WHERE lastName=:theData", Student.class);

		//set query parameters
		typedQuery.setParameter("theData", theLastName);
		
		//return query
		return typedQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		//retrieve the student
		Student theStudent = entityManager.find(Student.class, id);
		
		//delete the student
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}



}
