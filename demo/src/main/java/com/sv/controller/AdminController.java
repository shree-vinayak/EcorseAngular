package com.sv.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.model.Students;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AdminController {
	
	private static List<Students> studentsList= new ArrayList<>();
	
	static 
	{
		Students s = new Students(); 
		s.setFathername("Gayaprashad Rajpoot");
		s.setImagepath("Testpath");
		s.setMobileno("7898311713");
		s.setMothername("babita Rajpoot");
		s.setName("Ankit Rajpoot");
		s.setRollno("108");
		studentsList.add(s);
	}
	
	@GetMapping("get-students")
	public Object getAllStudents(HttpServletRequest request)
	{
		String token= request.getHeader("Authorization");
		if(isvalidToken(token))
		{
			return studentsList;
		}
		else
		{
			return "TOKEN EXPIRED, LOGIN AGAIN.";
		}
	}
	
	private boolean isvalidToken(String token) {
		if(token.equals("thisismyjsonwebtoken"))
			return true;
		return false;
	}
	
	
	

}
