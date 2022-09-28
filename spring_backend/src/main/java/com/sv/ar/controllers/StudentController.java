package com.sv.ar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.ar.entities.StudentDetails;
import com.sv.ar.services.StudentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/student-ops")
public class StudentController {

	
	@Autowired
	private StudentService  studentService; 
	
	
	
	@PostMapping("/savestudent")
	public Object saveTeachers(@RequestBody StudentDetails studentDetails, HttpServletRequest request)
	{
		
		
     	Object result=	studentService.save(studentDetails,request);
		
		return result; 
		
	}
}
