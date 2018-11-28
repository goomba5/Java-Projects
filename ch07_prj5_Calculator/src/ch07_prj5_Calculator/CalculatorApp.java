package ch07_prj5_Calculator;

import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		// display a welcome message
        System.out.println("Welcome to the Aperture Science Class Calculator Application");
        System.out.println();

        // create scanner object
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        	// int variables
        	int x = 0;
        	int y = 0;
        	int z = 0;
        	int sum = 0;
        	
        	// double variables
        	double a = 0.0;
        	double b = 0.0;
        	double c = 0.0;
        	double dblSum = 0.0;
        	
        	// create the calculator object
        	Calculator calculator = new Calculator();
        	
        	// display menu
        	System.out.println(calculator.getMenu());
        	
            // get the menu input
        	int menuNum = getInt(sc, "Enter menu number: ");
        	System.out.println(); // new line for space
        	if (menuNum == 1) {
        		
        		// calculate sum of two integers
        		x = getInt(sc, "Enter your first integer: ");
        		y = getInt(sc, "Enter your second integer: ");
        		
        		sum = calculator.getSum(x, y);
        		
                // display the output for int
                System.out.println("The sum of the numbers you entered is " + sum);
                System.out.println();
        		
        	} else if (menuNum == 2) {
        		
        		// calculate the sum of three integers
        		x = getInt(sc, "Enter your first integer: ");
        		y = getInt(sc, "Enter your second integer: ");
        		z = getInt(sc, "Enter your third integer: ");
        		
        		sum = calculator.getSum(x, y, z);
        		
                // display the output for int
                System.out.println("The sum of the numbers you entered is " + sum);
                System.out.println();
        		
        		System.out.println();
        		
        	} else if (menuNum == 3) {
        		
        		// calculate sum of two doubles
        		a = getDouble(sc, "Enter your first double: ");
        		b = getDouble(sc, "Enter your second double: ");
        		
        		dblSum = calculator.getSum(a, b);
        		
        		// display the output for double
                System.out.println("The sum of the numbers you entered is " + dblSum);
                System.out.println();
                
        	} else if (menuNum == 4) {
        		a = getDouble(sc, "Enter your first double: ");
        		b = getDouble(sc, "Enter your second double: ");
        		c = getDouble(sc, "Enter your third double: ");
        		
        		dblSum = calculator.getSum(a, b, c);
        		
        		// display the output for double
                System.out.println("The sum of the numbers you entered is " + dblSum);
                System.out.println();
                
        	} else {
        		System.out.println("Invalid entry. Please choose one of the menu options.");
        	}

//            // display the output for int
//            System.out.println("The sum of the numbers you entered is " + sum);
//            System.out.println();
//            
//            // display the output for double
//            System.out.println("The sum of the numbers you entered is " + dblSum);
//            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        
        // goodbye
        System.out.println("Thank you for using the Aperture Science Contact Selection Application");
        System.out.println("Goodbye!");

	}
	public static int getInt(Scanner sc, String prompt) {
		int x = 0;
		boolean isValid = false;
		
		while(!isValid) {
		System.out.print(prompt);
			if (sc.hasNextInt()) {
				 x = sc.nextInt();
				 isValid = true;
			} else {
				System.out.println("Invalid entry. Please enter a valid number.");
				isValid = false;
			}
			sc.nextLine();
		}
		return x;
	}
	
	public static double getDouble(Scanner sc, String prompt) {
		double x = 0;
		boolean isValid = false;
		
		while(!isValid) {
		System.out.print(prompt);
			if (sc.hasNextDouble()) {
				 x = sc.nextDouble();
				 isValid = true;
			} else {
				System.out.println("Invalid entry. Please enter a valid number.");
				isValid = false;
			}
			sc.nextLine();
		}
		return x;
	}

}
