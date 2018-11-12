package ch03_prj2_TravelTimeCalculator;

import java.util.Scanner;

public class TravelTimeCalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to the Travel Time Calculator");
		System.out.println();
		
		// create scanner object
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// create choice variable for while loop
		String choice = "y";
		
		// travel time logic stuff
		while(choice.equalsIgnoreCase("y")) {
			
			// prompt user for input
			System.out.print("Enter miles: ");
			double miles = sc.nextDouble();
			
			System.out.print("Enter miles per hour: ");
			double mph = sc.nextDouble();
			
			// calculate the hours and minutes
			double hours = Math.round(miles / mph);
			double minutes = Math.round(miles % mph);
			
			// display results
			System.out.println();
			System.out.println("Estimated travel time");
			System.out.println("----------------------");
			System.out.println("Hours: " + hours);
			System.out.println("Minutes: " + minutes);
			
			// continue?
			System.out.print("Continue? (y/n) ");
			choice = sc.next();
		}
		// goodbye
		System.out.println("Thank you for using the travel time calculator." +
		"\n" + "Goodbye!");
	}

}
