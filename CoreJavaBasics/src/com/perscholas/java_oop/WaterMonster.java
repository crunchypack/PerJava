package com.perscholas.java_oop;

public class WaterMonster extends Monster {

	public WaterMonster(String name) {
		super(name);
	}
	@Override
	public String attack() {
		String s = "Attack with water!";
		return s;
		
	}

}
