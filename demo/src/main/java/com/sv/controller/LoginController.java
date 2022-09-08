package com.sv.controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sv.model.Login;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class LoginController {

	
	@RequestMapping(value="/login" ,method=RequestMethod.POST )
	public Object  login(@RequestBody Login login)
	{
		
		HashMap<String, Object> result = new HashMap<>();
		
		
		if(login.getEmail().equals("admin@gmail.com")&&login.getPassword().equals("abc@123"))
		{
			Map<String, Object>  data = new HashMap<>(); 
			data.put("emailid", login.getEmail());
			result.put("token","thisismyjsonwebtoken");
			result.put("role","ADMIN"); 
			result.put("flag",true); 
			result.put("msg","Login Successfully");
			result.put("data",data);
		}
		else
		{
			result.put("flag",false); 
			result.put("msg","Invalid Credential");
			result.put("data",null);
		}
		
		return result;
	}
}
 