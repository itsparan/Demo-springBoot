package com.test.springuser.service;

import java.util.List;
import com.test.springuser.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.springuser.Entity.Student;
@Service
public class StudentServiceImpl implements StudentService {
	
	//setup constructor injection for studenDAO services
	/*
	 * private StudentService studentService;
	 * 
	 * @Autowired public StudentServiceImpl(StudentService theStudentService) {
	 * studentService= theStudentService; }
	 */
	
	
	private com.test.springuser.DAO.StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(com.test.springuser.DAO.StudentDAO theStudentDAO) {
		studentDAO=theStudentDAO;
	
		
	}

	@Override
	@Transactional
	public List<Student> findAll() {
		
		return studentDAO.findAll();
	}

	@Override
	@Transactional
	public Student findById(int theStudent_id) {
		// TODO Auto-generated method stub
		return studentDAO.findById(theStudent_id);
	}

	@Override
	@Transactional
	public void deleteByStudent_id(int theID) {
		
		studentDAO.deleteByStudent_id(theID);
		// TODO Auto-generated method stub

	}

	@Override
	//@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		studentDAO.save(theStudent);

	}

	@Override
	public List<Student> findAll1() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
