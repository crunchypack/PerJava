package com.perscholas.java_basics;

public class JavaBasic {

	public static void main(String[] args) {
		basicOne();
		basicTwo();
		basicThree();
		basicFour();
		basicFive();
		basicSix();
		basicSeven(5.2);
		basicEight();

	}
	public static int basicOne() {
		int a = 2;
		int b = 3;
		
		int sum = a + b;
		
		System.out.println(sum);
		return 0;
	}
	public static int basicTwo() {
		double a = 2.5;
		double b = 3.0;
		
		double sum = a + b;
		
		System.out.println(sum);
		return 0;
	}
	public static int basicThree() {
		int a = 3;
		double b = 66.1;
		
		double sum = a + b; // The sum must be a double 
		
		System.out.println(sum);
		return 0;
	}
	
	public static void basicFour() {
		int a = 901;
		int b = 30;
		
		int c = a/b;
		System.out.println(c);

		double d = 901.0; // Changing the larger number to a decimal gives a mismatch error
		
		double e = d/b; // So we declare a double to hold the expression instead
		System.out.println(e);
	}
	public static void basicFive(){
		// Declaration and initialization
		double a = 66.7;
		double b = 33.3;
		// calculation
		double c = a / b;
		
		System.out.println(c);
		// casting
		int d = (int) c;
		
		System.out.println(d);
	}
	public static void basicSix() { // Please explain better I dont understand the last question
		int x = 5, y = 6;
		
		double q = y/x;
		System.out.println(q);
		
		q = (double)y;
		
		System.out.println(q);
		
	}
	public static void basicSeven(double feet) {
		// feet to meter constant
		final double CONVERTION = 0.3048;
		// calculation
		double meter = feet * CONVERTION;
		
		System.out.printf("%.2f meters. You hobbit! %n", meter);
		
	}
	public static void basicEight() {
		// Variables
		int coffeeeeeeee;
		int cappuccino;
		int greenTea;
		// initialization 
		coffeeeeeeee = 3;
		cappuccino = 5;
		greenTea = 3;
	
		int subTotal;
		double totalSale;
		// "Order"
		subTotal = 3*coffeeeeeeee + 4*cappuccino + 2*greenTea;
		// Sales tax (NYC)
		final double SALES_TAX = 8.875;
		// Add to subtotal and print
		totalSale = SALES_TAX + subTotal;
		System.out.printf("Your total is $%.2f", totalSale);
	}

}
