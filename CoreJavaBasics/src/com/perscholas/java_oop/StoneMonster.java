package com.perscholas.java_oop;

public class StoneMonster extends Monster {

	public StoneMonster(String name) {
		super(name);
	}
	@Override
	public String attack() {
		String s = "Attack with stone!";
		return s;
		
	}

}
