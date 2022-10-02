package com.sv.ar.services;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.ar.DTOs.UpdateMarksDto;
import com.sv.ar.entities.Login;
import com.sv.ar.entities.MarksTable;
import com.sv.ar.entities.TeacherDetails;
import com.sv.ar.repositories.Login_repo;
import com.sv.ar.repositories.MarksTable_repo;
import com.sv.ar.repositories.Teacher_repo;
import com.sv.ar.utilities.ResponseWrapper;
import com.sv.ar.utilities.Validate;

@Service
public class TeacherService {

	@Autowired
	private Teacher_repo teacher_repo;

	@Autowired
	private Login_repo loginrepo;

	@Autowired
	private MarksTable_repo marksrepo;

	public Object save(TeacherDetails teacherdetils, HttpServletRequest request) {
		teacherdetils.setCreatedat(LocalDate.now());
		ResponseWrapper result = new ResponseWrapper();
		if (Validate.validateToken(request)) {
			Login logindetail = new Login();
			logindetail.setMobileno(teacherdetils.getTeachermobile());
			logindetail.setName(teacherdetils.getTeachername());
			logindetail.setPassoword(teacherdetils.getTeacherpassword());
			logindetail.setRole(teacherdetils.getTeacherrole());
			logindetail.setUsername(teacherdetils.getTeacherusername());

			try {
				Login logindbObj = loginrepo.save(logindetail);

				if (logindbObj != null) {
					teacherdetils.setCreatedat(LocalDate.now());
					TeacherDetails teacherdb = teacher_repo.save(teacherdetils);
					result.setMsg("TEACHER REGISTRATION SUCCESSFULLY");
					result.setFlag(true);
					result.setData(teacherdb);
				} else {
					result.setMsg("CAN NOT SAVE LOGIN DETAILS");
					result.setFlag(false);
					result.setData(null);
				}
			} catch (Exception e) {
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

	public Object updateMarks(UpdateMarksDto updatemarks, HttpServletRequest request) {
		ResponseWrapper result = new ResponseWrapper();
		if (Validate.validateToken(request)) {
			TeacherDetails teacherDetailsdb = teacher_repo.findById(updatemarks.getEnteredby()).get();
			if (teacherDetailsdb.getTeachersubject().equals("PHYSICS")) {
				int noOfupdaterecords = marksrepo.updateMarksForSubject1(updatemarks.getStudentusername(),
						updatemarks.getMarks(), updatemarks.getExamptype());
				createResult(noOfupdaterecords, result, updatemarks.getStudentusername());

			} else if (teacherDetailsdb.getTeachersubject().equals("CHEMISTRY")) {
				int noOfupdaterecords = marksrepo.updateMarksForSubject2(updatemarks.getStudentusername(),
						updatemarks.getMarks(), updatemarks.getExamptype());
				createResult(noOfupdaterecords, result, updatemarks.getStudentusername());

			} else if (teacherDetailsdb.getTeachersubject().equals("MATHS")) {
				int noOfupdaterecords = marksrepo.updateMarksForSubject3(updatemarks.getStudentusername(),
						updatemarks.getMarks(), updatemarks.getExamptype());
				createResult(noOfupdaterecords, result, updatemarks.getStudentusername());

			}
		} else {
			result.setMsg("Not Authorized");
			result.setFlag(false);
			result.setData(null);
		}
		return result;
	}

	private void createResult(int noOfupdaterecords, ResponseWrapper result, String studentusername) {
		if (noOfupdaterecords == 1) {
			result.setMsg("Marks Update Successfully for Student " + studentusername);
			result.setFlag(true);
			result.setData(null);
		} else {
			result.setMsg("Can Not update Marks for student" + studentusername);
			result.setFlag(false);
			result.setData(null);
		}
	}

}
