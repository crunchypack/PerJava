package com.perscholas.java_oop;

public class FireMonster extends Monster {

	public FireMonster(String name) {
		super(name);
	}

	@Override
	public String attack() {
		String s = "Attack with fire!";
		return s;
		
	}
		
}
