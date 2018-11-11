package ch02_prj2_RectangleCalculator;

import java.util.Scanner;

public class RectangleCalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// display welcome message
		System.out.println("Welcome to the Rectangle Calculator!");
		System.out.println();
		
		// create scanner object
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// create while loop that contains business logic
		String choice = "y";
		while(choice.equalsIgnoreCase("y")){
			
			// retrieve user input for length
			System.out.print("Enter length: ");
			double length = sc.nextDouble();
			
			// retrieve user input for length
			System.out.print("Enter width: ");
			double width = sc.nextDouble();
			
		// display results
		double area = length * width;
		double perimeter = (length * 2) + (width * 2);
		
			// print area
			System.out.println("Area: " + area);
			
			// print perimeter
			System.out.println("Perimeter: " + perimeter);
		
		// continue?
		System.out.print("Continue? (y/n) ");
		choice = sc.next();
		}
		System.out.println("Goodbye!");
	}

}
