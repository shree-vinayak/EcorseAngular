package com.sv.ar.DTOs;

import java.util.List;

public class ExamResultRespDtoWrapper {
     private String name; 
     private String age;
     private String classname; 
     private String status;
     private String examtype; 
     private String rollno;
     private List<ExamResultRespDto> examResultRespDto;
     private List<String> failsIn;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getExamtype() {
		return examtype;
	}
	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public List<ExamResultRespDto> getExamResultRespDto() {
		return examResultRespDto;
	}
	public void setExamResultRespDto(List<ExamResultRespDto> examResultRespDto) {
		this.examResultRespDto = examResultRespDto;
	}
	public List<String> getFailsIn() {
		return failsIn;
	}
	public void setFailsIn(List<String> failsIn) {
		this.failsIn = failsIn;
	} 
     
     
	
	
     
     
     
     
     
     
}
