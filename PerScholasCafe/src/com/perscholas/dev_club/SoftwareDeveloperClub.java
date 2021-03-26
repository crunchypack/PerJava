package com.perscholas.dev_club;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SoftwareDeveloperClub {
	protected ArrayList<ClubMember> data = new ArrayList<ClubMember>();
	protected String location;
	/**
	 * Creates an array list of ClubMembers 
	 * @param location The path to the file containing club members
	 */
	public SoftwareDeveloperClub(String location) {
		this.location = location;
		// Reading in the file and storing in the ArrayList
		try (Scanner in = new Scanner(new File(location));){
			
			in.nextLine();
			while(in.hasNextLine()) {
				String [] line = in.nextLine().split("\\*\\*");
				data.add(new ClubMember(line[0], line[1], line[2], line[3]));
			}
			in.close();
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
	
		}
	}
	/**
	 * Menu for the user to pick different choices
	 */
	public void menu() {
		Scanner in = new Scanner(System.in);
		// making sure that real inputs are used. try block will break the while loop if successful.
		while(true) {
			System.out.println("Select from the following menu: ");
			System.out.println("1: Display Members\n2: Remove Member\n3: Add Member\n4: Save File\n5: Quit");
			System.out.print("Your input: ");
			try {
				// Switch case to call different methods based on user input.
				int i = in.nextInt();
				do {
					switch (i){
					case 1:
						displayMembers();
						break;
					case 2:
						removeMember();
						break;
					case 3:
						addMember();
						break;
					case 4:
						saveFile();
						break;
					case 5:
						System.out.println("Bye bye");
					default:
						System.out.println("Try again! ");
						break;
					}
					System.out.println("1: Display Members\n2: Remove Member\n3: Add Member\n4: Save File\n5: Quit");
					System.out.print("Your input: ");
					i = in.nextInt();
					
				}while (i != 5);
				// if user quits we break the while(true) loop
				System.out.println("Bye bye");
				break;
			}catch (Exception e) {
				System.out.println("Wrong input!");
				in.next();
			}
		}
		
	}
	/**
	 * Prints out all the members in the ArrayList
	 */
	public void displayMembers() {
		for(ClubMember c: data) {
			System.out.printf("Member Name: %s %nLocation: %s,%s %nFavorite Language: %s%n%n",c.getName(),c.getCity(),c.getState(),c.getLang());
		}
	}
	/**
	 * Saves the ArrayList members to the textfile.
	 */
	public void saveFile() {
		File f = new File(location);
		try {
			// We must overwrite since we go over the entire list.
			FileWriter wr = new FileWriter(f,false);
			wr.write("NAME**CITY**STATE**FAVORITE PROGRAMMING LANGUAGE\n");
			for(ClubMember c: data) {
				wr.write(String.format("%s**%s**%s**%s%n", c.getName(),c.getCity(),c.getState(),c.getLang()));
			}					
			wr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Removes a member from the ArrayList
	 */
	public void removeMember() {
		int i = 0;
		// Printing out the members name with numbers corresponding to their index
		System.out.println("Which member would you like to remove :");
		for(ClubMember c: data) {
			System.out.printf("%d: %s%n", i,c.getName());
			i++;
		}
		System.out.println("-1. Cancel");
		Scanner in = new Scanner(System.in);
		// Until a valid input is received 
		while(true) {
			try {
				System.out.print("You input: ");
				int rem = in.nextInt();
				if(rem != -1) { // Remove the member using index
					System.out.println("Removing " + data.get(rem).getName());
					data.remove(rem);
				}
				
				break;
			}catch(Exception e){
				System.out.println("Try again!");
				in.nextLine();
			}
		}
	}
	/**
	 * Add a member to the ArrayList
	 */
	public void addMember() {
		// Instead of taking in multiple inputs we take one and ask for commas 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name, city, state and favorite language (Separated by comma): ");
		String name = sc.nextLine();
		// Using the commas we split the String into an Array of Strings
		String[] arr = name.split(",");
		// If the user input is at least separated with four commas we input the ClubMember to the List
		if(arr.length == 4) {
			ClubMember c = new ClubMember(arr[0], arr[1], arr[2], arr[3]);
			data.add(c);
		}
		else {// if not, we say invalid and the program goes back to main menu
			System.out.println("Invalid number of inputs");
		}
		
//		System.out.print("Enter city: ");
//		String city = sc.nextLine();
//		System.out.print("Enter State");
	}
	

}
