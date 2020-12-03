package com.test.springuser.DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.test.springuser.Entity.Student;
import com.test.springuser.restController.*;
import com.test.springuser.Entity.*;
import com.test.springuser.service.*;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class StudentDAOHibernetImp implements StudentDAO {
	
	private EntityManager entityManager;
	
	//set up construtor injection
	@Autowired
	public StudentDAOHibernetImp(EntityManager TheEntityManager) {
		entityManager=TheEntityManager;
		// TODO Auto-generated constructor stub
	}

	@Override
	//@Transactional
	public List<Student> findAll() {
		// hello
		//get the hibernate session 
		Session currentSession= entityManager.unwrap(Session.class);
		
		//create query
		Query<Student> forquery=currentSession.createQuery("FROM  Student", Student.class);
		
		//execute query and get result list 
		List<Student>students=forquery.getResultList();
		
		//return the result
		
		
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public Student findById(int theStudent_id) {
		//get the hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		// find student by student_id 
		Student thestudent=currentSession.get(Student.class, theStudent_id);
		
		//return the student
		
		return thestudent;
	}

	@Override
	public void deleteByStudent_id(int theID) {
		Session currentSession=entityManager.unwrap(Session.class);
		//delete the student by id 
		Query thequery= currentSession.createQuery("delete from Student where student_id=:studentid");
		thequery.setParameter("studentid",theID);
		thequery.executeUpdate();
		System.out.println(thequery);
				}

	@Override
	public void save(Student theStudent) {
		Session curreSession = entityManager.unwrap(Session.class);
		//save student
		curreSession.saveOrUpdate(theStudent);
		
		
	}

}
