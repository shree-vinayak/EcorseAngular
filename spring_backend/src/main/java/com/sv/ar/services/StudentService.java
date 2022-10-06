package com.sv.ar.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.ar.DTOs.ExamResultRespDto;
import com.sv.ar.DTOs.ExamResultRespDtoWrapper;
import com.sv.ar.DTOs.MarksResponseDto;
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
		    		 List<String> studentUsernameList= new ArrayList<>();
	    			 for(StudentDetails studentobj:studentfromdb)
	    			 {
	    				 studentUsernameList.add(studentobj.getStudentusername());
	    			 }
		    		
	    			 Map<String,MarksResponseDto > mapobj= new HashMap<>(); 
		    		if(teacherObj.getTeachersubject().equals("PHYSICS"))
		    		{
		    			//Get the data where subject1 marks is null or empty 
		    			List<MarksTable> marsksdataList= marksTable_repo.getStudentForSubject1(studentUsernameList);
		    			processMarksTableData(marsksdataList,mapobj);
		    		}
		    		else if(teacherObj.getTeachersubject().equals("CHEMISTRY"))
		    		{
		    			List<MarksTable> marsksdataList= marksTable_repo.getStudentForSubject2(studentUsernameList);
		    			processMarksTableData(marsksdataList,mapobj);
		    		}
		    		else if(teacherObj.getTeachersubject().equals("MATHS"))
		    		{
		    			List<MarksTable> marsksdataList= marksTable_repo.getStudentForSubject3(studentUsernameList);
		    			processMarksTableData(marsksdataList,mapobj);
		    		}
		    		
		    		List<MarksResponseDto> marksResponseDtoList = new ArrayList<>(mapobj.values());
		    		if(!marksResponseDtoList.isEmpty())
		    		{
		    			result.setMsg("GET DATA SUCCESSFULLY");
						result.setFlag(true);
						result.setData(marksResponseDtoList);
		    		}
		    		else
		    		{
		    			result.setMsg("NO DATA FOUND FOR TEACHER" +teacherusername.toUpperCase());
						result.setFlag(false);
						result.setData(null);
		    		}
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
	
	
	public void updatemarks()
	{
//		fetchthe teacherObject
//		check the teacher subject
//		if physics==> update  marsktable set subject1marsk=(:marks)  where studentusername=(:studentusername) and examtype=(:examptype)
//		else if CHEMISTRY	==> update  marsktable set subject2marsk=(:marks)  where studentusername=(:studentusername) and examtype=(:examptype)
//	else if  MATHS	==> update  marsktable set subject3marsk=(:marks)  where studentusername=(:studentusername) and examtype=(:examptype)
	}
	
	private void processMarksTableData(List<MarksTable> marsksdataList,Map<String,MarksResponseDto > mapobj)
	{
		
		for(MarksTable marksdbObj:marsksdataList)
		{
			if(mapobj.containsKey(marksdbObj.getStudentusername()))
			{
				MarksResponseDto dto= mapobj.get(marksdbObj.getStudentusername()); 
				if(marksdbObj.getExamtype().equals(ExamType.halfyearly))
				{
					dto.setHalfyearly(true);
				}
				else if (marksdbObj.getExamtype().equals(ExamType.quaterly))
				{
					dto.setQuaterly(true);
				}
				else if(marksdbObj.getExamtype().equals(ExamType.finalEXM))
				{
					dto.setFinalexam(true);
				}
			}
			else
			{
				MarksResponseDto dto= new MarksResponseDto();
				dto.setStudentusername(marksdbObj.getStudentusername());
				if(marksdbObj.getExamtype().equals(ExamType.halfyearly))
				{
					dto.setHalfyearly(true);
				}
				else if (marksdbObj.getExamtype().equals(ExamType.quaterly))
				{
					dto.setQuaterly(true);
				}
				else if(marksdbObj.getExamtype().equals(ExamType.finalEXM))
				{
					dto.setFinalexam(true);
				}
				
				mapobj.put(marksdbObj.getStudentusername(), dto);
				
			}
			
		}
		
		
	}


	public Object getResultForExamFromService(String studentusername, String examtype, HttpServletRequest request) {
		ResponseWrapper result = new ResponseWrapper();
		if (Validate.validateToken(request)) {
			
			boolean status=false; 
			
			
		    StudentDetails studentDetails= student_repo.findById(studentusername).get();
		    ExamResultRespDtoWrapper  examresultrespdtowrapper= new ExamResultRespDtoWrapper();
		    examresultrespdtowrapper.setAge(studentDetails.getStudentage());
		    examresultrespdtowrapper.setClassname(studentDetails.getStudentclass());
		    examresultrespdtowrapper.setExamtype(examtype);
		    examresultrespdtowrapper.setName(studentDetails.getStudentname());
		    examresultrespdtowrapper.setRollno(studentDetails.getStudentusername());
		    List<ExamResultRespDto> examlist= new ArrayList<>(); 
		    List<String>failsInList=  new ArrayList<>();
           MarksTable marksTable=   marksTable_repo.getResultForExamtype(studentusername,examtype);
           ExamResultRespDto subject1Obj=new ExamResultRespDto(); 
           subject1Obj.setExamName(marksTable.getSubject1());
           subject1Obj.setTotalmarks("100");
           subject1Obj.setMarks(marksTable.getSubject1marks()==null?"MARKS NA":marksTable.getSubject1marks());
           examlist.add(subject1Obj);
           if(Float.parseFloat(marksTable.getSubject1marks())<33f)
           {
        	   status=true;
        	   failsInList.add("FAILED IN "+marksTable.getSubject1());
           }
           
           ExamResultRespDto subject2Obj=new ExamResultRespDto(); 
           subject2Obj.setExamName(marksTable.getSubject2());
           subject2Obj.setTotalmarks("100");
           subject2Obj.setMarks(marksTable.getSubject2marks()==null?"MARKS NA":marksTable.getSubject2marks());
           examlist.add(subject2Obj);
           if(Float.parseFloat(marksTable.getSubject2marks())<33f)
           {
        	   status=true;
        	   failsInList.add("FAILED IN "+marksTable.getSubject2());
           }
           
           ExamResultRespDto subject3Obj=new ExamResultRespDto(); 
           subject3Obj.setExamName(marksTable.getSubject3());
           subject3Obj.setTotalmarks("100");
           subject3Obj.setMarks(marksTable.getSubject3marks()==null?"MARKS NA":marksTable.getSubject3marks());
           examlist.add(subject3Obj);
           if(Float.parseFloat(marksTable.getSubject3marks())<33f)
           {
        	   status=true;
        	   failsInList.add("FAILED IN "+marksTable.getSubject3());
           }
           
           examresultrespdtowrapper.setExamResultRespDto(examlist);
           examresultrespdtowrapper.setStatus(status==true?"FAIL":"PASS");
           if(!failsInList.isEmpty())
           {
        	   examresultrespdtowrapper.setFailsIn(failsInList);
           }
           
            result.setMsg("Getting Result Successfully");
			result.setFlag(true);
			result.setData(examresultrespdtowrapper);
           
          
		} else {
			result.setMsg("Not Authorized");
			result.setFlag(false);
			result.setData(null);
		}
		return result;
	}

}
