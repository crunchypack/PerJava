package com.perscholas.cafe;

public abstract class Product {
	private String name, description;
	private double price;
	private int quantity;
	
	public Product() {
		
	}
	public Product (String n, double p, String des) {
		this.setName(n);
		this.setPrice(p);
		this.setDescription(des);
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public abstract double calculateProductTotal();
	
	public abstract void addOptions(String s, String p);
	
	public abstract String[] printOptions();
	

}
