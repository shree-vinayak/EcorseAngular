package com.sv.ar.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.ar.entities.Login;
import com.sv.ar.entities.MarksTable;
import com.sv.ar.entities.StudentDetails;
import com.sv.ar.entities.TeacherDetails;
import com.sv.ar.repositories.Login_repo;
import com.sv.ar.repositories.MarksTable_repo;
import com.sv.ar.repositories.Student_repo;
import com.sv.ar.repositories.Teacher_repo;
import com.sv.ar.utilities.ExamType;
import com.sv.ar.utilities.ResponseWrapper;
import com.sv.ar.utilities.Validate;

@Service
public class StudentService {
	
	@Autowired
	private Student_repo student_repo;
	
	
	@Autowired
	private  MarksTable_repo marksTable_repo;
	
	@Autowired
	private Login_repo login_repo;
	
	
	@Autowired
	private Teacher_repo teacher_repo; 
	
	

	public Object save(StudentDetails studentDetails, HttpServletRequest request) {
		studentDetails.setCreatedate(LocalDate.now());
		ResponseWrapper result = new ResponseWrapper();
		if (Validate.validateToken(request)) {
			Login logindetail= new Login(); 
			logindetail.setMobileno(studentDetails.getStudentmobile());
			logindetail.setName(studentDetails.getStudentname());
			logindetail.setPassoword(studentDetails.getStudentpassword());
			logindetail.setRole(studentDetails.getRole());
			logindetail.setUsername(studentDetails.getStudentusername());
			
			try
			{
				Login logindbObj= login_repo.save(logindetail);
				
				if(logindbObj!=null)
				{
					
					MarksTable  quateryly= new MarksTable(); 
					quateryly.setStudentusername(studentDetails.getStudentusername());
					quateryly.setExamtype(ExamType.quaterly);
					quateryly.setSubject1("PHYSICS");
					quateryly.setSubject2("CHEMISTRY");
					quateryly.setSubject3("MATHS");
					
					MarksTable  halfyeraly= new MarksTable(); 
					halfyeraly.setStudentusername(studentDetails.getStudentusername());
					halfyeraly.setExamtype(ExamType.halfyearly);
					halfyeraly.setSubject1("PHYSICS");
					halfyeraly.setSubject2("CHEMISTRY");
					halfyeraly.setSubject3("MATHS");
					
					MarksTable  finalexam= new MarksTable(); 
					finalexam.setStudentusername(studentDetails.getStudentusername());
					finalexam.setExamtype(ExamType.finalEXM);
					finalexam.setSubject1("PHYSICS");
					finalexam.setSubject2("CHEMISTRY");
					finalexam.setSubject3("MATHS");
					List<MarksTable> examptypelist= new ArrayList<>();
					examptypelist.add(quateryly);
					examptypelist.add(halfyeraly);
					examptypelist.add(finalexam);
					marksTable_repo.saveAll(examptypelist);
					StudentDetails student_repodb= student_repo.save(studentDetails);
				    result.setMsg("STUDENT REGISTRATION SUCCESSFULLY");
					result.setFlag(true);
					result.setData(student_repodb);
					
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


	public Object getStudentForEnterMarks(String teacherusername, HttpServletRequest request) {
		    ResponseWrapper result = new ResponseWrapper();
		    if (Validate.validateToken(request)) {
			    TeacherDetails teacherObj= teacher_repo.findById(teacherusername).get();
			    List<String> classslist= Arrays.asList(teacherObj.getAssignedclass1(),teacherObj.getAssignedclass2(),teacherObj.getAssignedclass3());
		    	List<StudentDetails> studentfromdb= student_repo.getStudentForEnterMarks(classslist);
		    	
		    	if(!studentfromdb.isEmpty())
		    	{
		    		result.setMsg("GET DATA SUCCESSFULLY");
					result.setFlag(true);
					result.setData(studentfromdb);
		    	}
		    	else
		    	{
		    		result.setMsg("NO DATA FOUND FOR TEACHER "+teacherusername.toUpperCase());
					result.setFlag(false);
					result.setData(null);
		    	}
		    }
		    else
		    {
		    	result.setMsg("Not Authorized");
				result.setFlag(false);
				result.setData(null);
		    }
		return result;
	}

}
