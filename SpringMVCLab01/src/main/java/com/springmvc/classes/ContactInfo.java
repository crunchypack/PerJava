package com.springmvc.classes;

import springwork.customAnnotations.EmailConstraint;

public class ContactInfo {
	@EmailConstraint
	private String email;
	
	private String linkedUrl;
	private Long phoneNumber;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLinkedUrl() {
		return linkedUrl;
	}
	public void setLinkedUrl(String linkedUrl) {
		this.linkedUrl = linkedUrl;
	}
	public Long getPhoneNumber() {
		
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
