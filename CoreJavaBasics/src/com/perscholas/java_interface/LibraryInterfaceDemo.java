package com.perscholas.java_interface;

public class LibraryInterfaceDemo {

	public static void main(String[] args) {
		// Create kid with an age of 10 and register
		KidUser kid = new KidUser(10);
		kid.registerAccount();
		System.out.println();
		// Change age to 18 and try register again
		kid.setAge(18);
		kid.registerAccount();
		System.out.println();
		//Set the book type to kids and checkout
		kid.setBookType("Kids");
		kid.requestBook();
		System.out.println();
		//Change type to Fiction and try checkout again
		kid.setBookType("Fiction");
		kid.requestBook();
		System.out.println();
		// Create adult with age of 10 try register
		AdultUser adult = new AdultUser(5);
		adult.registerAccount();
		System.out.println();
		// Change age to 23 and try again
		adult.setAge(23);
		adult.registerAccount();
		System.out.println();
		// Set book type to Kids and try checkout
		adult.setBookType("Kids");
		adult.requestBook();
		System.out.println();
		// Change type to Fiction and try again
		adult.setBookType("Fiction");
		adult.requestBook();
		System.out.println();

	}

}
