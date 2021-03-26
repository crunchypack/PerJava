package com.perscholas.cafe;

public class Cappuccino extends Product {
	private boolean peppermint, whippedCream;

	public Cappuccino() {
		this.peppermint = false;
		this.whippedCream = false;
	}

	public Cappuccino(String n, double p, String des, boolean pepp, boolean whip) {
		super(n, p, des);
		this.peppermint = pepp;
		this.whippedCream = whip;
	}

	public boolean isPeppermint() {
		return peppermint;
	}

	public void setPeppermint(boolean pepp) {
		this.peppermint = pepp;
	}

	public boolean isWhippedCream() {
		return whippedCream;
	}

	public void setWhippedCream(boolean whip) {
		this.whippedCream = whip;
	}

	@Override
	public double calculateProductTotal() {
		double total = this.getPrice() * this.getQuantity();
		if(peppermint) {
			total += 2;
		}
		if(whippedCream) {
			total += 1;
		}
		return total;
	}
	@Override
	public void addOptions(String s, String p) {
		if(s.contains("y")||s.contains("Y")) {
			this.peppermint = true;
		}
		if(p.contains("y")||p.contains("Y")) {
			this.whippedCream = true;
		}
	}
	@Override
	public String[] printOptions() {
		String[] s = new String[2];
		if(peppermint) {
			s[0] = "Peppermint: Yes (Add $2)";
		}else {
			s[0] = "Peppermint: No";
		}
		if(whippedCream) {
			s[1]= "Whipped Cream: Yes (Add $1)";
		}else {
			s[1]="Whipped Cream: No";
		}
		return s;
	}

}
