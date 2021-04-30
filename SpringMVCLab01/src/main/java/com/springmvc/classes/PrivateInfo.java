package com.springmvc.classes;

import springwork.customAnnotations.DateOfBirthConstraint;

public class PrivateInfo {
	private Long ssn,ccn;
	
	@DateOfBirthConstraint
	private String dob; 
	
	public Long getSsn() {
		
		return ssn;
	}
	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	public Long getCcn() {
		return ccn;
	}
	public void setCcn(Long ccn) {
		this.ccn = ccn;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		
		this.dob = dob;
	}
}
