package com.sv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sv.model.Login;
import com.sv.model.Users;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class LoginController {
	
	public static List<Users> userslist= new ArrayList();
	

	static
	{
		Users admin= new Users(); 
		admin.setEmailid("admin@gmail.com");
		admin.setMobileno(7898311713l);
		admin.setPassword("abc@123");
		admin.setRole("ADMIN");
		userslist.add(admin);
		
		Users teacher= new Users(); 
		teacher.setEmailid("teacher@gmail.com");
		teacher.setMobileno(8319513178l);
		teacher.setPassword("abc@123");
		teacher.setRole("TEACHER");
		userslist.add(teacher);
		
;
		}
	
	
	@RequestMapping(value="/login" ,method=RequestMethod.POST )
	public Object  login(@RequestBody Login login)
	{
		
		boolean matched=false;
		
		HashMap<String, Object> result = new HashMap<>();
		
		for(Users user:userslist)
		{
			if(user.getEmailid().equals(login.getEmail()) && user.getPassword().equals(login.getPassword()))
			{
				Map<String, Object>  data = new HashMap<>(); 
				data.put("emailid", login.getEmail());
				result.put("token","thisismyjsonwebtoken");
				result.put("role",user.getRole()); 
				result.put("flag",true); 
				result.put("msg","Login Successfully");
				result.put("data",data);
				
				matched=true; 
				break;
			}
		}
		
		if(!matched)
		{
			result.put("flag",false); 
			result.put("msg","Invalid Credential");
			result.put("data",null);
		}
		
		return result;
	}
}
 