package com.perscholas.cafe;

public class Espresso extends Product {
	private boolean extraShot, macchiato;

	public Espresso() {
		this.extraShot = false;
		this.macchiato = false;
	}

	public Espresso(String n, double p, String des, boolean ex, boolean ma) {
		super(n, p, des);
		this.extraShot = ex;
		this.macchiato = ma;
	}

	public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean exraShot) {
		this.extraShot = exraShot;
	}

	public boolean isMacchiato() {
		return macchiato;
	}

	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}

	@Override
	public double calculateProductTotal() {
		double total = this.getPrice() * this.getQuantity();
		if(extraShot) {
			total += 2;
		}
		if(macchiato) {
			total += 1;
		}
		return total;
	}
	@Override
	public void addOptions(String s, String p) {
		if(s.contains("y")||s.contains("Y")) {
			this.extraShot= true;
		}
		if(p.contains("y")||p.contains("Y")) {
			this.macchiato = true;
		}
	}
	@Override
	public String[] printOptions() {
		String[] s = new String[2];
		if(extraShot) {
			s[0] = "Extra Shot: Yes (Add $2)";
		}else {
			s[0] = "Extra Shot: No";
		}
		if(macchiato) {
			s[1]= "Macchiato: Yes (Add $1)";
		}else {
			s[1]="Macchiato: No";
		}
		return s;
	}

}
