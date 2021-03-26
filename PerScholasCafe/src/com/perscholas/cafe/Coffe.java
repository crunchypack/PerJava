package com.perscholas.cafe;

public class Coffe extends Product {
	private boolean sugar, milk;
	public Coffe() {
		this.sugar = false;
		this.setMilk(false);
	}

	public Coffe(String n, double p, String des, boolean s, boolean m) {
		super(n, p, des);
		this.sugar = s;
		this.setMilk(m);
	}
	public boolean isSugar() {
		return sugar;
	}
	public void setSugar(boolean s) {
		this.sugar = s;
	}
	public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	@Override
	public double calculateProductTotal() {
		// TODO Auto-generated method stub
		return this.getPrice()*this.getQuantity();
	}
	@Override
	public void addOptions(String s, String p) {
		if(s.contains("y")||s.contains("Y")) {
			this.milk = true;
		}
		if(p.contains("y")||p.contains("Y")) {
			this.sugar = true;
		}
	}
	@Override
	public String[] printOptions() {
		String[] s = new String[2];
		if(milk) {
			s[0] = "Milk: Yes";
		}else {
			s[0] = "Milk: No";
		}
		if(sugar) {
			s[1]= "Sugar: Yes";
		}else {
			s[1]="Sugar: No";
		}
		return s;
		
	}
}
