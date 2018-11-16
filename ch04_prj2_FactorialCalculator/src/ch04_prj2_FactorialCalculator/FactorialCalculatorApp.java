package ch04_prj2_FactorialCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class FactorialCalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to the Aperture Science Factorial Calculator Application!");
		System.out.println(); // new line for space
		
		// create scanner object
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// create while loop for choice
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			
			// prompt user for input
			System.out.print("Enter an integer between 0 and 10: ");
			int digit = sc.nextInt();
			System.out.println(); // new line for space
			
			// create for loop to calculate the product
			int product = 1;
			
			for (int i = 2; i <= digit; i++) {
				product =  product * i;
			
			}
			// format the product
			NumberFormat intNumber = NumberFormat.getNumberInstance();
			String factorial = intNumber.format(product);
			
			// display result
			System.out.print(digit +"!" + " is equal to " + factorial + ".");
							
			
			// continue
			System.out.println(); // new line for space
			System.out.print("Continue? (y/n) ");
			choice = sc.next();
			
			System.out.println(); // new line for space
		}
		// goodbye
		System.out.print("Thank you for using the Aperture Science Factorial Calculator App!");
	}

}
