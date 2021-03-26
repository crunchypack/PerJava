package com.perscholas.java_oop;

public abstract class Monster {
	protected String name;
	public Monster(String name) {
		this.name = name;
	}
	public abstract String attack();
}
