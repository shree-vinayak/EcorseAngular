package com.sv.ar.responseDTO;

public class MarksResponseDto {
	private String studentusername;
	private boolean quaterly;
	private boolean halfyearly;
	private boolean finalexam;

	public String getStudentusername() {
		return studentusername;
	}

	public void setStudentusername(String studentusername) {
		this.studentusername = studentusername;
	}

	public boolean isQuaterly() {
		return quaterly;
	}

	public void setQuaterly(boolean quaterly) {
		this.quaterly = quaterly;
	}

	public boolean isHalfyearly() {
		return halfyearly;
	}

	public void setHalfyearly(boolean halfyearly) {
		this.halfyearly = halfyearly;
	}

	public boolean isFinalexam() {
		return finalexam;
	}

	public void setFinalexam(boolean finalexam) {
		this.finalexam = finalexam;
	}

	@Override
	public String toString() {
		return "MarksResponseDto [studentusername=" + studentusername + ", quaterly=" + quaterly + ", halfyearly="
				+ halfyearly + ", finalexam=" + finalexam + "]";
	}
	
	
	

}
