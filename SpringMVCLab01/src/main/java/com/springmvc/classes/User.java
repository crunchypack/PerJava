package com.springmvc.classes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import springwork.customAnnotations.PasswordConstraint;



public class User {
	private String firstName;
	private String lastName;
	
	@NotNull
	@Size(min=5, max=14, message= "User name must be between {2} and {1}")
	private String userName;
	
	@PasswordConstraint
	private String password;
	
	private String gender;
	
	private @Valid ContactInfo contactInfo;
	
	private @Valid PrivateInfo privateInfo;


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		
		this.contactInfo = contactInfo;
	}
	public PrivateInfo getPrivateInfo() {
		return privateInfo;
	}
	public void setPrivateInfo(PrivateInfo privateInfo) {
		this.privateInfo = privateInfo;
	}

}
