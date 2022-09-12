package com.sv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.sv.model.ResponseWrapper;
import com.sv.model.Teachers;


public class TeacherController {

	public static List<Teachers> teachersLIst = new ArrayList<>();

	
	public Object saveTeachers(@RequestBody Teachers teachers) {
		ResponseWrapper result = new ResponseWrapper();

		// NEED TO APPLY ALL NULL CHECK ON EVERY VARIABLE OF TEACHERS;
		if (teachers.getName() == null || teachers.getName().equals("")) {

			result.setFlag(false);
			result.setMsg("Name is required");
			return result;
		}

		if (teachers.getAddress() == null || teachers.getAddress().equals("")) {
			result.setFlag(false);
			result.setMsg("Address is required");
			return result;
		}
		
		
		try
		{
			String empId= "TECH_ID"+teachersLIst.size()+1;
			teachers.setEmpid(empId);
			teachersLIst.add(teachers);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			result.setFlag(false);
			result.setMsg("Some exception occurred, pls contact to support team");
			
		}
		
		
		for(int i=0; i<teachersLIst.size();i++)
		{
			Teachers  storetechers= teachersLIst.get(i);
			if(teachers.getEmpid().equals(storetechers))
			{
				storetechers.setAddress(teachers.getAddress());

				storetechers.setName(teachers.getName());
				storetechers.setAddress(teachers.getAddress());
				storetechers.setAddress(teachers.getAddress());
			}
		}
		
		
		
		return result;
	}
}
