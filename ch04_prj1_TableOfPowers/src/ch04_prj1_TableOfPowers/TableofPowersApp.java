package ch04_prj1_TableOfPowers;

import java.util.Scanner;

public class TableofPowersApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to the Aperture Science Companion Cubes Calculator!");
		System.out.println(); // new line for space
		
		// create scanner
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// create choice variable
		String choice = "y";
		
		// create while loop for logic
		while(choice.equalsIgnoreCase("y")) {
			
			// prompt user for inputs
			System.out.print("Enter an integer: ");
			int digit = sc.nextInt();
			System.out.println(); // new line for space
			
			// create for loop to iterate over outcomes for digit
			int i;
			
			for (i = 0; i <= digit; i++) {
				int squared = (i * i);
				int cubed = i * i * i;
				
				// display results
				System.out.print("Number: " + i + " " + "Squared: " + squared + 
								" " + "Cubed: " + cubed + "\n");
			}
			
			// continue
			System.out.println(); // new line for space
			
			System.out.print("Continue? (y/n) ");
			choice = sc.next();
			
			System.out.println(); // new line for space
			
		}
		System.out.print("Thank you for using the Aperture Science Companion Cubes Calculator"
				+ "\n" + "Goodbye, ___________!");
		System.out.println(); // new line for space
	}

}
