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
			double hours = 0;
			double minutes = 0;
			
			// prompt user for input
				
				// enter the method for getting miles
				double miles = getDouble(sc, "Enter miles: ", 0, 200);
				
				// enter the method for getting mph
				double mph = getDouble(sc, "Enter mph: ", 0, 200);
				
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
			System.out.print("Continue? (y/n) ");
			choice = sc.next();
	}
		// goodbye
		System.out.println(); // new line for space
		System.out.print("Thank you for using the travel time calculator." +
		"\n" + "Goodbye!");
	}
	
	private static double getDouble(Scanner sc, String prompt, double min, double max) {
		double x = 0.0;
		boolean isValid = false;
		
		while(!isValid) {
		
		System.out.print(prompt);
			if (sc.hasNextDouble()) {
				 x = sc.nextDouble();
				 isValid = true;
			} else {
				System.out.println("Invalid entry. Please enter a valid number.");
			}
			sc.nextLine();
			
			if (isValid && x <= 0) {
				System.out.println("Invalid entry. Number must be greater than 0.");
				isValid = false;
			} else if (isValid && x > 200) {
				System.out.println("Invalid entry. Number must be less than 200.");
				isValid = false;
			}
		}
		return x;
	}
	
	

}
