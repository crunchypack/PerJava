package com.perscholas.java_oop;

public class Employee {
	protected long employeeId;
	protected String employeeName;
	protected String employeeAddress;
	protected long employeePhone;
	protected double basicSalary;
	protected double specialAllowance = 250.8;
	protected double hra = 1000.5;
	
	public Employee (long id, String name, String address, long phone ) {
		this.employeeId = id;
		this.employeeName = name;
		this.employeeAddress = address;
		this.employeePhone = phone;
	}
	
	public void calculateSalary() {
		double salary = basicSalary + (basicSalary * specialAllowance/100) + (basicSalary*hra/100);
		System.out.println(salary);
	}
	public void calculateTransportAllowance() {
		double transportAllowance = 10*basicSalary/100;
		System.out.println(transportAllowance);
	}
}
