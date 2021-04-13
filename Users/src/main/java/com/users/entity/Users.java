package com.users.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(
	    name="findUser",
	    query="SELECT e FROM Users e WHERE e.email = :uemail AND e.password = :upass"
	)
public class Users {
	@Id
	private String email;
	
	private String name;
	private String password;
	private String address;
	private String state;
	private Integer zipcode; 

	public Users() {
		super();
	}

	public Users(String email, String name, String password, String address, String state, Integer zipcode) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Users) {
			Users other = (Users) obj;
			boolean sameEmail = (this.email.equals(other.getEmail()));
			boolean sameName = (this.name.equals(other.getName()));
			boolean samePass = (this.password.equals( other.getPassword()));
			boolean sameAddress = (this.address.equals(other.getAddress()));
			boolean sameState = (this.state.equals (other.getState()));
			boolean sameZip = (this.zipcode.intValue() == other.getZipcode().intValue());
			if(sameEmail && sameName && samePass && sameAddress && sameState && sameZip) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, name, password, address, state, zipcode);
	}
	

}
