package com.sv.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sv.model.Employee;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EmployeeController {

	public static List<Employee> empList = new ArrayList<Employee>();

	public void addemployess(List<Employee> empList) {
		if (empList.size() > 0) {

		} else {
			empList.add(new Employee(1, "harsh", 5));
			empList.add(new Employee(2, "aditya", 25));
			empList.add(new Employee(3, "babita", 65));
			empList.add(new Employee(4, "rajat", 15));
			empList.add(new Employee(5, "bhoora", 10));
		}
	}

	@GetMapping("/get-employees")
	public Object getListEmployees(HttpServletRequest request) {
		String token = request.getHeader("Authrization");
		if(isvalidToken(token))
		{
			addemployess(empList);
			return empList;
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

	@PostMapping("/save-employees")
	public Object saveEmployees(@RequestBody Employee emp) {

		System.out.println(emp);
		empList.add(emp);

		Map<String,String> result = new HashMap<>(); 
		result.put("msg", "Employee Added Successfully");
		
		return result;
	}
	
	
	@PutMapping("/update-employee")
	public String updateEmployees(@RequestBody Employee emp) {

		boolean  ispresent =false;
		if (empList.size()>0)
		{
			for (int i=0;i<empList.size();i++)
			{
				if(empList.get(i).getId()==emp.getId())
				{
					empList.get(i).setExperience(emp.getExperience());;
					empList.get(i).setName(emp.getName());;
					ispresent=true;
					return "Employee Details UPdated Successfully.";
				}
			}
			if(!ispresent)
			{
				return "Employee Details NOt Found in Database";
			}
		}
		else
		{
			
			return "NO Employee Present In Database.";
		}
		return "Employee Added Successfully";
	}
	
	
	@DeleteMapping("/delete-employee")
	public Object deleteEmployee(@RequestParam("id" )Integer id) {

		System.out.println(id);;
		
		Map<String,String> result = new HashMap<>(); 
		
		
		boolean ispresent=false;
		if(empList.size()>0)
		{
			for (int i=0;i<empList.size();i++)
			{
				if (empList.get(i).getId()==id)
				{
					ispresent=true;
					empList.remove(i);
					
					result.put("msg", "Employee Deleted successfully");
					return  result;
				}
			}
			
			if(!ispresent)
			{
				result.put("msg", "Employee Not Found");
				return result;
			}
		}
		else
		{
			result.put("msg", "No employees Found In database");
			return result;
		}
		
		
		result.put("msg", "No employees Found In database");
		return result;
		
		
	}
}
