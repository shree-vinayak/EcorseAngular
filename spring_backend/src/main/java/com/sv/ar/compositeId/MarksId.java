package com.sv.ar.compositeId;

import java.io.Serializable;

public class MarksId implements Serializable {

	private String studentusername;

	private String examtype;

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

}
