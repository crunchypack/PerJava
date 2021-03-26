package com.perscholas.java_interface;

public class AdultUser implements ILibraryUser {
	private int age;
	private String bookType;
	
	public AdultUser(int x) {
		this.age = x;
	}

	@Override
	public void registerAccount() {
		if(getAge() > 12) {
			System.out.println("You have successfully registered under an Adults Account");
		}
		else {
			System.out.println("Sorry you are to young to have an adult account.");
		}
	}

	@Override
	public void requestBook() {
		if (getBookType() != "Fiction") {
			System.out.println("Oops, you are allowed to take only adult Fiction books");
		}else {
			System.out.println("Book Issued successfully, please return the book within 7 days");
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
