package ch05_prj2_DataValidation;

import java.util.Scanner;

public class DataValidationApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to the Aperture Science Travel Time Calculator");
		
		// create scanner object
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// create choice variable for while loop
		String choice = "y";
		System.out.println(); // new line for space
		
		// travel time logic stuff
		while(choice.equalsIgnoreCase("y")) {
			double miles = 0.0;
			double mph = 50.0;
			double hours = 0;
			double minutes = 0;
			
			// prompt user for input
				
				System.out.print("Enter miles: ");
				if (sc.hasNextDouble()) {
					 miles = sc.nextDouble();
					 sc.nextLine();
				} else {
					System.out.print("Invalid entry. Please enter a valid number.\n");
					sc.nextLine();
					continue;
				}
				
//				System.out.print("Enter miles per hour: ");
//				if (sc.hasNextDouble()){
//					
//					mph = sc.nextDouble();
//					sc.nextLine();
//				} else {
//					System.out.print("Invalid entry. Please enter a valid number.");
//					sc.nextLine();
//					continue;
//				}
				
				// calculate the hours and minutes
					hours = Math.round(miles / mph);
					minutes = Math.round(miles % mph);
					
			// display results
			System.out.println();
			System.out.println("Estimated travel time");
			System.out.println("----------------------");
			System.out.println("Hours: " + hours);
			System.out.println("Minutes: " + minutes);
			System.out.println(); // new line for space
			
			// continue?
			System.out.print("Continue? (y/n) \n");
			choice = sc.next();
	}
		// goodbye
					System.out.println("Thank you for using the travel time calculator." +
					"\n" + "Goodbye!");
	}

}
