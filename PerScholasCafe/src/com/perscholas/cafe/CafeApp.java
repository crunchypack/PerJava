package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeApp {

	public static void main(String[] args) {
		// Declare variables
		double total = 0.0;
		double tax = 8.75;
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		// Creating ArrayList to store products
		ArrayList <Product> items= new ArrayList<Product>();
		do {
			System.out.println("Please select from the follwing menu:");
			System.out.print("1: Coffe\n2: Cappuccino\n3: Espresson\n4: Check out\nYour input: ");
			// making sure we get a valid input
			while(true) {
				try {
					choice = sc.nextInt();
					break;
				}catch (Exception e) {
					System.out.println("Try again please!: ");
					sc.next();
				}
			}
				switch(choice) {// Create product based on input.
				case 1:
					// Create product
					Coffe c = new Coffe("Coffe", 2.29,"From the Jungle",false,false);
					// Ask for options
					System.out.print("Do you want milk? y/n: ");
					String m = sc.next();
					System.out.print("Do you want sugar? y/n: ");
					String s = sc.next();
					// call method for options
					c.addOptions(m, s);
					// Ask and set quantity 
					c.setQuantity(getQuantity(c.getName()));
					// Add to ArrayList
					items.add(c);
					break;
				case 2:
					Cappuccino cap = new Cappuccino("Cappuccino", 3.99, "Now with cow milk!", false, false);
					System.out.print("Do you  want peppermint? y/n: ");
					String p = sc.next();
					System.out.print("Do you want whipped cream? y/n: ");
					String w = sc.next();
					cap.addOptions(p, w);
					cap.setQuantity(getQuantity(cap.getName()));
					items.add(cap);
					break;
				case 3:
					Espresso es = new Espresso("Espresson",4.49,"Italy approved",false,false);
					System.out.print("Do you  want extra shot? y/n: ");
					String ex = sc.next();
					System.out.print("Do you want macchiato? y/n: ");
					String ma = sc.next();
					es.addOptions(ex,ma);
					es.setQuantity(getQuantity(es.getName()));
					items.add(es);
					break;
				case 4:
					System.out.println();
					break;

				default:
					System.out.println("Try again");
					break;
					
				}
			
			
		}while(choice != 4);
		// Using the ArrayList to get the total price and print out each item.
		for(Product s : items) {
			printSub(s);
			total += s.calculateProductTotal();
		}
		// Printing subtotal, tax and total
		System.out.printf("%nSubtotal %9.2f %nTax %5.2f%% %7.2f%nTotal %12.2f", total,tax,(total*tax/100),(total*(tax/100+1)));
		sc.close();
		
		
		
	
		
	}
	/**
	 * Prints out information about product
	 * @param Product
	 */
	public static void printSub(Product s) {
		String[] add =s.printOptions();
		System.out.printf("Item: %-10s Price: $%-10s Qty:%-10d Subtotal: $%.2f%n",s.getName(),s.getPrice(),s.getQuantity(),s.calculateProductTotal());
		System.out.printf("      %s %15s\n", add[0],add[1]);
	}
	/**
	 * Get quantity based on user input
	 * @param String
	 * @return Integer
	 */
	public static int getQuantity(String p) {
		
		int items;
		boolean flag = true;
		Scanner s = null;
		do {
			items = -1;
			System.out.print("How many " + p + "'s: ");
			try {
				s = new Scanner(System.in);
				items = s.nextInt();
				if(items >= 0) {
					flag = false;			
				
				}else {
					System.out.println("Do not enter negative numbers");
					flag = true;
				}
				
			}catch(Exception e) {
				System.out.println("Please enter an actual number!");
				s.next();

			}
			
			
			
		}while(flag);
		return items;
	}

}
