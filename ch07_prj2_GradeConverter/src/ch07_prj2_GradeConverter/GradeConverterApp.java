package ch07_prj2_GradeConverter;

import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		
	     // display a welcome message
        System.out.println("Welcome to the Aperture Science Letter Grade Converter");
        System.out.println();

        // display contacts
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        	
            // get the input from the user
        	int numGrade = getInt(sc, "Enter the numerical grade: ");

            // get the Contact object
            Grade grade = new Grade(numGrade);

            // display the output
            System.out.println("Letter Grade: " + grade.getLetter());
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        // goodbye
        System.out.println("Thank you for using the Aperture Science Letter Grade Converter");
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
}
