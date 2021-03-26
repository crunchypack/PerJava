package dayone.javastuff;

import java.util.Scanner;

public class LoanPayment {
	public static void main (String[] arg) {
		Scanner sc = new Scanner(System.in);
			System.out.println("Enter interest rate, years and amount...");
			double interest = sc.nextDouble();
			int years = sc.nextInt();
			int amount = sc.nextInt();
		
			double month = amount*interest/(1-1/(Math.pow((1+interest), years * 12)));
		
		System.out.println(month);
		sc.close();

	}

}
// 1+4+1+5+1+6