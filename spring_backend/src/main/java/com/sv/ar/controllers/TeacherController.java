package com.sv.ar.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.ar.DTOs.UpdateMarksDto;
import com.sv.ar.entities.TeacherDetails;
import com.sv.ar.services.TeacherService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/teacher")
public class TeacherController {

	
	@Autowired
	private TeacherService  teacherService;
	
	@PostMapping("/saveTeacher")
	public Object saveTeachers(@RequestBody TeacherDetails teacherdetils, HttpServletRequest request)
	{
     	Object result=	teacherService.save(teacherdetils,request);
		return result; 
		
	}
	
	
	@PostMapping("/update-marks")
	public Object updateMarks(@RequestBody UpdateMarksDto updatemarks, HttpServletRequest request)
	{
     	Object result=	teacherService.updateMarks(updatemarks,request);
		return result; 
		
	}
	
	
}
