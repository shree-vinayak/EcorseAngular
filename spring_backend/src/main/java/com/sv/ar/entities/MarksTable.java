package com.sv.ar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.sv.ar.compositeId.MarksId;

@Entity
@Table(name="markstable")
@IdClass(MarksId.class)
public class MarksTable {

	@Id
	@Column(name="studentusername")
	private String studentusername;

	@Id
	@Column(name="examtype")
	private String examtype;

	@Column(name="subject1")
	private String subject1; 

	@Column(name="subject1marks")
	private String subject1marks;

	@Column(name="subject2")
	private String subject2;

	@Column(name="subject2marks")
	private String subject2marks; 

	@Column(name="subject3")
	private String subject3; 

	@Column(name="subject3marks")
	private String subject3marks;

	public String getStudentusername() {
		return studentusername;
	}

	public void setStudentusername(String studentusername) {
		this.studentusername = studentusername;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject1marks() {
		return subject1marks;
	}

	public void setSubject1marks(String subject1marks) {
		this.subject1marks = subject1marks;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject2marks() {
		return subject2marks;
	}

	public void setSubject2marks(String subject2marks) {
		this.subject2marks = subject2marks;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getSubject3marks() {
		return subject3marks;
	}

	public void setSubject3marks(String subject3marks) {
		this.subject3marks = subject3marks;
	}
	
	
	
	
	
	
}
