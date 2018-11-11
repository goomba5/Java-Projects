package ch03_prj1_TemperatureConverter;

import java.text.NumberFormat;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// app description
		System.out.println("Welcome to the Aperture Science Climate Control Converter!");
		System.out.println();
		
		// create scanner object
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		// prompt for user input
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			
			// ask for user input
			System.out.print("Enter degrees in Fahrenheit: ");
			double fahrenheit = sc.nextDouble();
			
			// Fahrenheit to Celsius conversion
			double conversion = (fahrenheit - 32) * 0.55555556;
			
			// format the result so there are two decimal places
			NumberFormat formatCelsius = NumberFormat.getNumberInstance();
			formatCelsius.setMaximumFractionDigits(2);
			String celsius = formatCelsius.format(conversion);
			
		// display result
		System.out.println("Degrees in Celsius: " + celsius);
		
		// continue? (y/n)
		System.out.print("Continue Testing? (y/n) ");
		choice = sc.next();
		}
		// goodbye!
		System.out.print("Thank you for using the Aperture Science Climate Control Converter.");
	}
}
