package com.perscholas.dev_club;

public class ClubMemberApp {

	public static void main(String[] args) {
		// By having the txt file in the project folder we don't need the entire filepath
		// Change to correct file path if you move the file
		String location = "members.txt";
		SoftwareDeveloperClub sdc = new SoftwareDeveloperClub(location);
		sdc.menu();
	}

}
