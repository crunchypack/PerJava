package com.perscholas.java_interface;

public class KidUser implements ILibraryUser {
	protected int age;
	protected String bookType;
	
	public KidUser(int x) {
		this.age = x;
	}
	@Override
	public void registerAccount() {
		if(age < 12) {
			System.out.println("You have successfully registered under a Kids Account");
		}
		else {
			System.out.println("Sorry you are to old to have a kids account.");
		}

	}

	@Override
	public void requestBook() {
		if (bookType != "Kids") {
			System.out.println("Oops, you are allowed to take only kids books");
		}else {
			System.out.println("Book Issued successfully, please return the book within 10 days");
		}

	}
	protected String getBookType() {
		return bookType;
	}

	protected void setBookType(String bookType) {
		this.bookType = bookType;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

}
