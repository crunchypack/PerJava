package com.perscholas.java_multi;

public class Account  {
	protected int balance;
	
	public Account() {
		this.balance = 50;
	}
	
	public int getBalance() {
		return balance;
	}

	public void withdrawal(int sum) {
		balance = balance - sum;
		
	}
	

}
