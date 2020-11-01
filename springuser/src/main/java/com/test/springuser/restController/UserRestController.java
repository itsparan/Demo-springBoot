package com.test.springuser.restController;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springuser.Entity.Student;
import com.test.springuser.service.StudentService;
@RequestMapping("/user")
@RestController
public class UserRestController {
	
	private StudentService studentService;

	public UserRestController(StudentService theStudentService) {
		System.out.println("stc controller is working");
		studentService = theStudentService;
	}


	// expose "/" that return "Hello World"
	//for testing purpose on url

	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}

	
	@GetMapping("/students")
	public List<Student> findAll() {
		System.out.println("get Controler is working");
		return studentService.findAll();

	}

	// add mapping for get student by student id
	@GetMapping("/students/{student_id}")
	
	public Student getStudent(@PathVariable int student_id) {
		Student theStudent = studentService.findById(student_id);
		System.out.println(student_id);
		if (theStudent == null) {
			throw new RuntimeException("given student id does not exist=" + student_id);
		}
		return theStudent;

	}

	// post maping for add student
	@PostMapping("/addStudents")
	public Student addStudent(@RequestBody Student theStudent) {
		  
		 theStudent.setStudent_id(0);
		 //theStudent.setAge();
		 
		studentService.save(theStudent);
		return theStudent;
	}
	
	
	// put mapping for update
	@PutMapping("/updateStudents")
	public Student updateEmployee(@RequestBody Student theStudent) {
		
		studentService.save(theStudent);
		
		return theStudent;
	}
	
	// add mapping for DELETE /
	
	@DeleteMapping("/students/{student_id}")
	public String deleteEmployee(@PathVariable int student_id) {
		
		Student tempstudents = studentService.findById(student_id);
		
		// throw exception if null
		
		if (tempstudents == null) {
			throw new RuntimeException("Employee id not found - " + student_id);
		}
		
		studentService.deleteByStudent_id(student_id);
		
		return "Deleted student id - " + student_id;
	}
	


}




