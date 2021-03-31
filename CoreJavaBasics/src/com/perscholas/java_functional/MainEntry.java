package com.perscholas.java_functional;

import java.util.Scanner;

public class MainEntry {
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// Implementations of Calc as inline code
		Calc add = new Calc(){ // Add function
			/**
			  * Adds the values in the array of Integers
			  */
			@Override
			public void compute(int[] values) { 
				
				if(values != null && values.length > 1) { // Checks that we have at least 2 numbers and that the array isn't null
					int sum = 0;
					StringBuffer res = new StringBuffer(); // String buffer to build a string to print
					
					for(int i : values) {
						if(res.length() != 0) { // We want to add plus (+) sign after the first number has been added
							res.append(" + ");  // So if the buffer is empty we don't add the plus sign
						}
						res.append(i);		// Add the current value to the buffer
						sum += i;
					}
					res.append(" = "); // Adds the equal sign 
					res.append(sum); // and the sum
					System.out.println(res); // prints out the StringBuffer
				}else {
					System.out.println("Please enter at least two numbers!");
				}
				
			}
		};
		Calc sub = new Calc() {
			/**
			 * Subtracts the values in the array
			 */
			@Override
			public void compute(int[] values) {
				if(values != null && values.length > 1) {
					int sum = values[0];
					StringBuffer res = new StringBuffer();
					res.append(sum);
					
					for(int i = 1; i < values.length; i++) { // Non enhanced for loop since we begin on the second element
						res.append(" - ");
						res.append(values[i]);
						
						sum -= values[i];
					}
					res.append(" = ");
					res.append(sum);
					System.out.println(res);
				}else {
					System.out.println("Please enter at least two numbers!");
				}
				
			}
		};
		Calc mult = new Calc() {
			/**
			 * Multiplies the values of the array
			 */
			@Override
			public void compute(int[] values) {
				if(values != null && values.length > 1) {
					StringBuffer res = new StringBuffer();
					int sum = values[0];

					res.append(sum);
					for(int i = 1; i < values.length; i++) {
						res.append(" * ");
						res.append(values[i]);
						
						sum *= values[i];
					}
					res.append(" = ");
					res.append(sum);
					System.out.println(res);
				}else {
					System.out.println("Please enter at least two numbers!");
				}
				
			}
		};
		Calc div = new Calc() {
			@Override
			public void compute(int[] values) {
				if(values != null && values.length == 2) { // check that we have exactly 2 values
					try{
						int result = values[0] / values[1];
						System.out.println(values[0] + " / " + values[1] + " = " + result);
					}catch(ArithmeticException e) {
						System.out.println("It is forbidden to divide by zero");
					}
					
				}else {
					System.out.println("Please enter two numbers for division!");
				}
			}
		};
		int choice = 0;
		while(choice != 5) { // Program runs until user has decided to quit
			menu();
			while(true) { // Make sure the user picks an Integer
				try {
					choice = sc.nextInt();
					break;
				}catch(Exception e) {
					System.out.println("Please enter a valid number!");
					sc.next();
					menu();
				}
			}
			
			switch(choice) { // Switch case to determine which operation gets called
			case 1:
				System.out.println("Enter multiple numbers (at least two) separated by space");
				sc.nextLine();
				String[] addS = sc.nextLine().split(" ");
				add.compute(convert(addS));
				break;
			case 2:
				System.out.println("Enter multiple numbers (at least two) separated by space");
				sc.nextLine();
				String[] subS = sc.nextLine().split(" ");
				sub.compute(convert(subS));
				break;
			case 3:
				System.out.println("Enter multiple numbers (at least two) separated by space");
				sc.nextLine();
				String[] multiS = sc.nextLine().split(" ");
				mult.compute(convert(multiS));
				break;
			case 4:
				System.out.println("Enter two numbers separated by space");
				sc.nextLine();
				String[] divS = sc.nextLine().split(" ");
				div.compute(convert(divS));
				break;
			case 5:
				System.out.println("Bye bye");
				break;
			default:
				System.out.println("Not a valid option\nTry again!");
				break;
			}			
		}
		sc.close();
		
	}
	/**
	 * Converts an Array of Strings to an Array of Integers
	 * @param v the Array of Strings
	 * @return An Array of Integers
	 */
	public static int[] convert(String[] v) {
		int[] values = new int[v.length];// Create an Array with the same length of the received Array
		
		for(int i = 0; i < v.length; i++) {
			try { // Making sure only numbers get sent
				values[i] = Integer.parseInt(v[i]); // Each value is turned into Integers and added to the Array
			}catch(NumberFormatException e){
				System.out.println("Only use numbers please!");
				return null;
			}
			
		}
		return values;
	}
	/**
	 * Displays a menu for the user
	 */
	public static void menu() {
		System.out.println("Choose an action:");
		System.out.println("1. Add ");
		System.out.println("2. Substract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Quit");
	}
}
