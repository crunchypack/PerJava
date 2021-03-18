import java.util.Scanner;
public class Area{
	public static void main(String[] args){
		// Variable declaration
		double radius;
		double area;
		// Scanner creation
		Scanner input = new Scanner(System.in);
		// prompt the user
		System.out.println("Input radius...");
		// store user input 
		radius = input.nextDouble();
		
		area = radius * radius * 3.14159;
		input.close();
		System.out.println("The area is: " + area);
	}
}