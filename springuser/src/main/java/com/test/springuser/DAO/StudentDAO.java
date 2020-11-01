package com.test.springuser.DAO;

import java.util.List;

import com.test.springuser.Entity.Student;

public interface StudentDAO {
	
public List<Student>findAll();

//find employee by id 
public Student findById(int theStudent_id);

//delete employee
public void deleteByStudent_id(int theID );

//save employee
public void save(Student theStudent);

}
