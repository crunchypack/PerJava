package com.perscholas.java_oop;

public class Trainee extends Employee {

	public Trainee(long id, String name, String address, long phone, double salary) {
		super(id, name, address, phone);
		this.basicSalary = salary;
	}

}
