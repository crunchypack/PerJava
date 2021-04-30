package com.springmvc.classes;



public class User {
	private String firstName,lastName,userName,gender;
	private ContactInfo contactInfo;
	private PrivateInfo privateInfo;

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
