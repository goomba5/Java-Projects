package ch02_prj1_StudentRegistration;

// import the Scanner object from Java library
import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		
		// welcome message
		System.out.println("Student Registration Form");
		
		System.out.println("Welcome! Please enter the following information to start.");
		
		@SuppressWarnings("resource")
		
		// create scanner object to obtain user input
		Scanner sc = new Scanner(System.in);
		
		// prompt user for input
		// while the user enters choice == "y", run this code
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			// prompt for first name
			System.out.println("Enter first name: ");
			String firstName = sc.next();
			
			// prompt for last name
			System.out.println("Enter last name: ");
			String lastName = sc.next();
			
			// prompt for birth year
			System.out.println("Enter birth year: ");
			int birthYear = sc.nextInt();
			

			// display results
				//print welcome message to user
				System.out.println("Welcome to the University of Cincinnati, " 
				+ firstName + " " + lastName + ".");
				
				// print "registration complete"
				System.out.println("Your registration is now complete!");
				
				// print temporary password
				System.out.println("Your temporary password is: " + firstName + "*" + birthYear);
				
			// continue?
				System.out.println("Continue? (y/n) ");
				choice = sc.next();
				
			// say goodbye!
				if (choice.equalsIgnoreCase("n"))
				System.out.println("Goodbye, " + firstName + "!");
		}

	}

}
