package lecture;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class LectureTwo {

	public static void main(String[] args) {
		

		         Integer arr[] = {1,3,5,7,9,2,4,6,8};

		         Arrays.stream(arr).skip(2).sorted().skip(3)

		          .forEach(x -> System.out.println(x));


		
		
	}
	public static void hexToDec() {
		System.out.print("Enter hexadecimal number: ");
		
		Scanner sc = new Scanner(System.in);
		String hex= sc.next();
		sc.close();
		try {
			int decimal=Integer.parseInt(hex,16); 
			System.out.println("Decimal: "+decimal);  
		}
		catch(Exception e) {
			System.out.println("Try again and please enter an actual hex number.."  );
		}
	
	}
	public static void lottery() {
		// declare a winning number RANDOMLY between 10 and 99
		int winner = (int) (Math.random()*100)+10;
		// Open scanner for user input.
		System.out.println("Winning number is: " + winner);
		Scanner sc = new Scanner(System.in);
		// We trust the user to input a two digit number
		System.out.print("Enter two didgit number: ");
		
		// We store it in a String
		String number = sc.next(); 
		sc.close();
		//check for winning number
		
		if(winner == Integer.parseInt(number)) {
			System.out.println("You win $5000");
		}else {// here is why we use string.
			String win = Integer.toString(winner); 
			if(number.charAt(0)== win.charAt(1) && number.charAt(1) == win.charAt(0) ) {
				System.out.println("You win $1000");
			}else if(number.charAt(0) == win.charAt(0) || number.charAt(0) == win.charAt(1) || number.charAt(1) == win.charAt(0) || number.charAt(1) == win.charAt(1)) {
				System.out.println("You win $250");
			}
			else {
				System.out.println("You win $0.00... collect at your moms house");
			}
		}
		
	}
	public static void bmi() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter weight in kilograms: ");
		double weight = sc.nextDouble();
		
		System.out.print("Enter height in meters: ");
		double height = sc.nextDouble();
		
		sc.close();
		double bmi = weight/(height*height);
		System.out.printf("Weight is: %.2f %nHeight is %.2f%n", weight, height );
		if(bmi < 18.5) {
			System.out.printf("You are underweight with a BMI of %.2f", bmi );
		}else if(bmi >= 18.5 && bmi < 25.0) {
			System.out.printf("You have a normal weight with a BMI of %.2f", bmi );
		}else if(bmi >= 25.0 && bmi < 30.0) {
			System.out.printf("You are overweight with a BMI of %.2f", bmi );
		}
		else {
			System.out.printf("You are obese with a BMI of %.2f", bmi );
		}
		
	}
	public static void chineseZodiac() {
		Scanner sc = new Scanner(System.in);
		int year;
		System.out.print("Enter a year: ");
		try {
			year = sc.nextInt();
		}catch(Exception e) {
			year = -1;
		}
		sc.close();
		
		int zodiac = year % 12;
		String res; 
		switch (zodiac) {
		case 0: 
			res = "Monkey";
			break;
		case 1: 
			res = "Rooster";
			break;
		case 2: 
			res = "Dog";
			break;
		case 3: 
			res = "Pig";
			break;
		case 4: 
			res = "Rat";
			break;	
		case 5: 
			res = "Ox";
			break;		
		case 6: 
			res = "Tiger";
			break;		
		case 7: 
			res = "Rabbit";
			break;		
		case 8: 
			res = "Dragon";
			break;		
		case 9: 
			res = "Snake";
			break;		
		case 10: 
			res = "Horse";
			break;		
		case 11: 
			res = "Sheep";
			break;
		default:
			res = "Funny Guy";
		}
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		if(year < currYear) {
			System.out.printf("Year %d was the year of The %s", year,res);
		}else if(year > currYear) {
			System.out.printf("Year %d will be the year of The %s", year,res);
		}else {
			System.out.printf("This year is the year of The %s",res);
		}
	}
}
