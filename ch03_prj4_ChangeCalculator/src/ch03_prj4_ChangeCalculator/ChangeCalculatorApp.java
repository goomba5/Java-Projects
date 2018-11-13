package ch03_prj4_ChangeCalculator;

import java.util.Scanner;

public class ChangeCalculatorApp {

	public static void main(String[] args) {
		
		// display welcome message
		System.out.println("Welcome to the Aperture Science Change Calculator!");
		System.out.println(); // new line for space
		
		// create scanner class
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// create choice
		String choice = "y";
		
		// create program loop
		while(choice.equalsIgnoreCase("y")) {
			
			// prompt user for the number of cents
			System.out.println(); // new line for space
			System.out.print("Enter number of cents (0-99): ");
			int cents = sc.nextInt();
			
			// initialize each coin
			int quarters = 0;
			int dimes = 0;
			int nickels = 0;
			int pennies = 0;
			int newCents = 0;
			
				// subtract amount from the cents for each coin
				
				if (cents <= 99) {
					quarters = cents / 25;
					
					newCents = cents - (quarters * 25);
					
					if (newCents <= 75) {
						dimes = newCents / 10;
						newCents -= (dimes * 10);
						
						if (newCents <= 25) {
							nickels = newCents / 5;
							newCents -= (nickels * 5);
							
							if (newCents < 10) {
								pennies = newCents / 1;
							}
						}
					}
				}
			
			
			// display results
			System.out.println("Quarters: " + quarters);
			System.out.println("Dimes: " + dimes);
			System.out.println("Nickels: " + nickels);
			System.out.println("Pennies: " + pennies);
			
			// continue?
			System.out.println(); // new line for space
			System.out.print("Continue? (y/n) ");
			choice = sc.next();
		}
		// goodbye!
		System.out.println(); // new line for space
		System.out.print("Thank you for using the Aperture Science Change Calculator."
				+ "\n" + "Goodbye!");
		System.out.println(); // new line for space
	}

}
