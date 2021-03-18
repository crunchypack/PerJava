package com.perscholas.java_flow;

import java.util.Scanner;

public class DailyTask {

	public static void main(String[] args) {
		taskSix();
	}
	public static void taskOne() {
		int x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}

	}
	public static void taskTwo() {
		int x = 15;
		if(x < 10) {
			System.out.println("Less than 10");
		}else if(x > 10) {
			System.out.println("Greater than 10");
		}
	}
	public static void taskThree() {
		int x = 20;
		if(x < 10) {
			System.out.println("Less than 10");
		}else if(x > 10 && x < 20) {
			System.out.println("Between 10 and 20");
		}else {
			System.out.println("Greater than or equal to 20");
		}
		
	}
	public static void taskFour() {
		int x = 5;
		if(x < 10 || x > 20) {
			System.out.println("Out of range");
		}else {
			System.out.println("In range");
		}
	}
	public static void taskFive() {
		Scanner sc = new Scanner(System.in);
		int grade;
		
		System.out.print("Enter grade (0-100): ");
		try {
			grade = sc.nextInt();
		}catch(Exception e) {
			System.out.println("Invalid input");
			grade = -1;
		}
		
		sc.close();
		
		if(grade < 0 || grade > 100) {
			System.out.println("Score out of range.");
		}else if(grade <= 100 && grade >= 90) {
			System.out.println("A");
		}else if(grade <= 89 && grade >=80) {
			System.out.println("B");
		}else if(grade <= 79 && grade >=70 ) {
			System.out.println("C");
		}else if(grade <= 69 && grade >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
	public static void taskSix() {
		Scanner sc = new Scanner(System.in);
		int day;
		String res;
		
		System.out.print("Enter the weekday number (1-7): ");
		try {
			day = sc.nextInt();
		}catch(Exception e) {
			System.out.println("Invalid input");
			day = -1;
		}
		sc.close();
		switch(day) {
			case 1 : res = "Monday"; break;
			case 2 : res = "Tuesday"; break;
			case 3 : res = "Wednesday"; break;
			case 4 : res = "Thursday"; break;
			case 5 : res = "Friday"; break;
			case 6 : res = "Saturday"; break;
			case 7 : res = "Sunday"; break;
			default : res ="Out of range";
		}
		System.out.println(res);
	}

}
