package com.test.springuser.service;

import java.util.List;

import com.test.springuser.Entity.Student;

public interface StudentService {
	public List<Student> findAll1();
	//find employee by id 
	public Student findById(int theStudent_id);

	//delete employee
	public void deleteByStudent_id(int theID );
	//save employee

	public void save(Student theStudent);
	// student data
	public List<Student> findAll();
	

}
