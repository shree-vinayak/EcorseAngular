package com.sv.ar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TeacherDetails")
public class TeacherDetails {

	@Id
	@Column(name = "teacherusername")
	private String teacherusername;
	
	@Column(name = "teachername")
	private String teachername;
	
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
	
	@Column(name = "createdAt")
	private LocalDate createdAt;

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

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

}
