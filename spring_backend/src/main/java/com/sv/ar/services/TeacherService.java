package com.sv.ar.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.ar.entities.TeacherDetails;
import com.sv.ar.repositories.Teacher_repo;

@Service
public class TeacherService {

	
	@Autowired
	private Teacher_repo teacher_repo;

	public Object save(TeacherDetails teacherdetils) {
		teacherdetils.setCreatedAt(LocalDate.now());
		//insert username,password, role  and other detaiils inside the login table
//		if success
		// insert operation inside the TeacherDetails table  return result 
		 
		return null;
	} 
	
}
