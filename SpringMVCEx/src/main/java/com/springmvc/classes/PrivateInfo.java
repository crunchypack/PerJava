package com.springmvc.classes;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PrivateInfo {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob; 
	

	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date  getDob() {
		return dob;
	}
	
}
