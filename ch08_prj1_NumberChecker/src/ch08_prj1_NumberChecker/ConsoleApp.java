package ch08_prj1_NumberChecker;

import java.util.Scanner;

public class ConsoleApp {

	public static void main(String[] args) {
		
		// display welcome message
		System.out.println("Welcome to the Aperture Science Number Evaluator Application");
		System.out.println(); // new line for space
		
		Scanner sc = new Scanner(System.in);
		
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        	
        	MyConsole console = new MyConsole();
        	
        	// prompt user for input
        	int integer = console.getInt(sc, "Enter an integer: ");
        	
        	// display if the integer is even/odd
        	System.out.println(console.numberCheck(integer));
        	
            // see if the user wants to continue
        	System.out.println(); // new line for space
            choice = console.getString("Continue? (y/n) ");
            System.out.println();
        }
        // goodbye
        System.out.println("Thank you for using the Aperture Science Number Evaluator Application"
        					+ "\n" + "Goodbye!");
	}

}
