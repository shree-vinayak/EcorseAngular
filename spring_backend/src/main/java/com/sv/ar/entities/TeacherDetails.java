package com.sv.ar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacherdetails")
public class TeacherDetails {

	@Id
	@Column(name = "teacherusername")
	private String teacherusername;
	
	@Column(name = "teachername")
	private String teachername;
	

	@Column(name = "teacherrole")
	private String teacherrole;
	
	@Column(name = "school")
	private String school;
	
	@Column(name = "teacherage")
	private String teacherage;
	
	@Column(name = "teachersubject")
	private String teachersubject;
	
	@Column(name = "teachermobile")
	private String teachermobile;
	
	@Column(name = "teacheraddress")
	private String teacheraddress;
	
	@Column(name = "teacherexp")
	private String teacherexp;
	
	@Column(name = "teacherpassword")
	private String teacherpassword;

	@Column(name = "createby")
	private String createby;
	
	@Column(name = "createdat")
	private LocalDate createdat;
	
	@Column(name = "assignedclass1")
	private String assignedclass1;
	
	@Column(name = "assignedclass2")
	private String assignedclass2;
	
	@Column(name = "assignedclass3")
	private String assignedclass3;
	
	
	
	

	public String getTeacherrole() {
		return teacherrole;
	}

	public void setTeacherrole(String teacherrole) {
		this.teacherrole = teacherrole;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTeacherage() {
		return teacherage;
	}

	public void setTeacherage(String teacherage) {
		this.teacherage = teacherage;
	}

	
	public String getTeacherusername() {
		return teacherusername;
	}

	public void setTeacherusername(String teacherusername) {
		this.teacherusername = teacherusername;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeachersubject() {
		return teachersubject;
	}

	public void setTeachersubject(String teachersubject) {
		this.teachersubject = teachersubject;
	}

	public String getTeachermobile() {
		return teachermobile;
	}

	public void setTeachermobile(String teachermobile) {
		this.teachermobile = teachermobile;
	}

	public String getTeacheraddress() {
		return teacheraddress;
	}

	public void setTeacheraddress(String teacheraddress) {
		this.teacheraddress = teacheraddress;
	}

	public String getTeacherexp() {
		return teacherexp;
	}

	public void setTeacherexp(String teacherexp) {
		this.teacherexp = teacherexp;
	}

	public String getTeacherpassword() {
		return teacherpassword;
	}

	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public LocalDate getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDate createdat) {
		this.createdat = createdat;
	}

	public String getAssignedclass1() {
		return assignedclass1;
	}

	public void setAssignedclass1(String assignedclass1) {
		this.assignedclass1 = assignedclass1;
	}

	public String getAssignedclass2() {
		return assignedclass2;
	}

	public void setAssignedclass2(String assignedclass2) {
		this.assignedclass2 = assignedclass2;
	}

	public String getAssignedclass3() {
		return assignedclass3;
	}

	public void setAssignedclass3(String assignedclass3) {
		this.assignedclass3 = assignedclass3;
	}


}
