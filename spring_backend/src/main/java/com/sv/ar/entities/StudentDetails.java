package com.sv.ar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studenedetails")
public class StudentDetails {

	@Id
	@Column(name = "studentusername")
	private String studentusername;

	@Column(name = "studentname")
	private String studentname;

	@Column(name = "studentpassword")
	private String studentpassword;

	@Column(name = "studentclass")
	private String studentclass;

	@Column(name = "studentage")
	private String studentage;

	@Column(name = "studentmobile")
	private String studentmobile;

	@Column(name = "role")
	private String role;

	@Column(name = "createdby")
	private String createdby;

	@Column(name = "createdate")
	private LocalDate createdate;

	@Column(name = "studentschool")
	private String studentschool;

	public String getStudentusername() {
		return studentusername;
	}

	public void setStudentusername(String studentusername) {
		this.studentusername = studentusername;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentpassword() {
		return studentpassword;
	}

	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}

	public String getStudentclass() {
		return studentclass;
	}

	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}

	public String getStudentage() {
		return studentage;
	}

	public void setStudentage(String studentage) {
		this.studentage = studentage;
	}

	public String getStudentmobile() {
		return studentmobile;
	}

	public void setStudentmobile(String studentmobile) {
		this.studentmobile = studentmobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	public String getStudentschool() {
		return studentschool;
	}

	public void setStudentschool(String studentschool) {
		this.studentschool = studentschool;
	}

}
