package ch07_prj1_ContactList;

import java.util.Scanner;

public class ContactListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // display a welcome message
        System.out.println("Welcome to the Aperture Science Contact Selection Application");
        System.out.println();

        // display contacts
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        	
            // get the input from the user
            System.out.print("Please enter the contact's name you wish to view: ");
            String firstName = sc.next();  // read the contact name
            sc.nextLine();  // discard any other data entered on the line

            // get the Contact object
            Contact contact = ContactDB.getContact(firstName);

            // display the output
            System.out.println();
            System.out.println("Current Contact");
            System.out.println("Full Name:           " + contact.getFirstName() + " " + contact.getLastName());
            System.out.println("Email Address:       " + contact.getEmail());
            System.out.println("Phone Number:        " + contact.getPhoneNumber());
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        // goodbye
//        System.out.println();
        System.out.println("Thank you for using the Aperture Science Contact Selection Application");
        System.out.println("Goodbye!");
	}

}
