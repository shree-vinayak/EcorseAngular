package com.sv.ar.services;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.ar.entities.Login;
import com.sv.ar.entities.TeacherDetails;
import com.sv.ar.repositories.Login_repo;
import com.sv.ar.repositories.Teacher_repo;
import com.sv.ar.utilities.ResponseWrapper;
import com.sv.ar.utilities.Validate;

@Service
public class TeacherService {

	@Autowired
	private Teacher_repo teacher_repo;
	
	@Autowired
	private Login_repo loginrepo; 
	

	public Object save(TeacherDetails teacherdetils, HttpServletRequest request) {
		teacherdetils.setCreatedat(LocalDate.now());
		ResponseWrapper result = new ResponseWrapper();
		if (Validate.validateToken(request)) {
			Login logindetail= new Login(); 
			logindetail.setMobileno(teacherdetils.getTeachermobile());
			logindetail.setName(teacherdetils.getTeachername());
			logindetail.setPassoword(teacherdetils.getTeacherpassword());
			logindetail.setRole(teacherdetils.getTeacherrole());
			logindetail.setUsername(teacherdetils.getTeacherusername());
			
			try
			{
				Login logindbObj= loginrepo.save(logindetail);
				
				if(logindbObj!=null)
				{
					teacherdetils.setCreatedat(LocalDate.now());
				    TeacherDetails teacherdb= 	teacher_repo.save(teacherdetils);
				    result.setMsg("TEACHER REGISTRATION SUCCESSFULLY");
					result.setFlag(true);
					result.setData(teacherdb);
				}
				else
				{
					result.setMsg("CAN NOT SAVE LOGIN DETAILS");
					result.setFlag(false);
					result.setData(null);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				result.setMsg("CAN NOT SAVE LOGIN DETAILS,MAY BE USER WITH THIS USERNAME IS ALREADY REGISTERED");
				result.setFlag(false);
				result.setData(null);
			}
			

		} else {
			result.setMsg("Not Authorized");
			result.setFlag(false);
			result.setData(null);
		}

		return result;
	}

}
