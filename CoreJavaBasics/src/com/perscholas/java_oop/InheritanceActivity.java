package com.perscholas.java_oop;

public class InheritanceActivity {

	public static void main(String[] args) {
		Employee m = new Manager(126534, "Peter", "Chennai India", 237844, 65000.0);
		System.out.print(m.employeeName + ":");
		m.calculateSalary();
		m.calculateTransportAllowance();
		
		Employee t = new Trainee(29846,"Jack","Mambai India", 442085, 45000.0);
		System.out.print(t.employeeName + ":");
		t.calculateSalary();
		t.calculateTransportAllowance();
	}

}
