package com.perscholas.java_oop;

public class Manager extends Employee {

	public Manager(long id, String name, String address, long phone, double salary) {
		super(id, name, address, phone);
		this.basicSalary = salary;
	}
	@Override
	public void calculateTransportAllowance() {
		double transportAllowance = 15*basicSalary/100;
		System.out.println(transportAllowance);
	}

}
