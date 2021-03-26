	package com.perscholas.java_loop;

import lecture.Student;

public class DailyTasks {

	public static void main(String[] args) {
		Student natalie = new Student(1,"Natalie","Davidsson","Hello@bye.com","555-891-2732");
		System.out.print(divisor_sum(6));
	}
	public static int divisor_sum(int n){
        int sum = 0; 
        for(int i = 1; i < n; i++ ){
            if(n%i == 0){
                sum += i;
            }
        }
        return sum;
    }
	public static void taskOne() {
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		
		
	}
	public static void taskTwo() {
		for(int i = 0; i<=100; i+=10) {
			System.out.println(i);
		}
	}
	public static void taskThree() {
		int i = 1;
		do {
			System.out.println(i);
			i++;
		}while(i <= 10);
	}
	public static void taskFour() {
		for(int i = 1; i <= 100; i++) {
			if(i >= 25 && i <= 75) {
				continue;
			}
			if(i % 5 == 0) {
				System.out.println(i);
			}
		}
	}
	public static void taskFive() {
		for(int i = 1; i <= 100; i++) {
			if(i > 50) {
				break;
			}
			if(i % 5 == 0) {
				System.out.println(i);
			}
		}
	}
	
	public static void taskSix() {
		for(int i = 1; i <= 2; i++) {
			System.out.println("Week " + i + ":");
			for(int d = 1; d < 8; d++) {
				System.out.println("Day " + d);
			}
		}
	}
	
	public static void taskSeven() {
		for(int i = 10; i <= 200; i++) {
			int rev = 0, rem, original = i;
			while(i != 0) {
				rem = i % 10;
				rev = rev*10+rem;
				i /= 10;
			}
			if(original == rev) {
				System.out.println(original);
			}
			i = original;
		}
	}
	public static void taskEight() {
		
		int num = 0;
		int num_2= 1;
		
		while(num <= 50 ) {
			System.out.println(num);
			
			int fib = num + num_2;
			num = num_2;
			num_2 = fib;
		}
	}
	
	public static void taskNine() {
		for(int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				System.out.println("Inner loop, i: "+ i + ", j: " + j);
			}
		}
	}

}
