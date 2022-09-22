package com.sv.ar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.ar.entities.TeacherDetails;
import com.sv.ar.services.TeacherService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherController {

	
	@Autowired
	private TeacherService  teacherService;
	
	public Object saveTeachers(@RequestBody TeacherDetails teacherdetils)
	{
		
		
     	Object result=	teacherService.save(teacherdetils);
		
		return result; 
		
	}
	
	
}
