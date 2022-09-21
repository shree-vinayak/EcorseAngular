package com.sv.ar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.ar.entities.Login;
import com.sv.ar.services.LoginService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/login-ops")
public class LoginController {
	
	@Autowired
	private LoginService loginservice; 
	
	
	@PostMapping("login")
	public Object login(@RequestBody Login login)
	{
	    Object obj= 	loginservice.validateLogin(login);
	    return obj;
		
	}
	
	
	@PostMapping("registration")
	public Object registration(@RequestBody Login login)
	{
	    Object obj= 	loginservice.register(login);
	    return obj;
		
	}

}
