package com.sv.ar.DTOs;

public class UpdateMarksDto {
	private String studentusername;
	private String marks;
	private String examptype;
	private String enteredby;

	
	
	

	public String getStudentusername() {
		return studentusername;
	}

	public void setStudentusername(String studentusername) {
		this.studentusername = studentusername;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getExamptype() {
		return examptype;
	}

	public void setExamptype(String examptype) {
		this.examptype = examptype;
	}

	public String getEnteredby() {
		return enteredby;
	}

	public void setEnteredby(String enteredby) {
		this.enteredby = enteredby;
	}

}
