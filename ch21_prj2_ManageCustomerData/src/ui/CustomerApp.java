package ui;

import java.sql.SQLException;
import java.util.List;
import business.Customer;
import db.CustomerDB;
import util.Console;

public class CustomerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Customer Manager");
		
		// declare console object
		Console console = new Console();
		
		//declare db object
		CustomerDB cdb = new CustomerDB();
		
		// create while loop
		String choice = " ";
		
		while(!choice.equalsIgnoreCase("exit")) {
			
			// present menu
			getMenu();
			
			// retrieve user input
			choice = console.getString("Enter a command: ");
			
			// options for the user
			if(choice.equalsIgnoreCase("list")) {
				System.out.println("CUSTOMER LIST\n");
				
				// call the DB to get the list of customers
				// must be wrapped in try-catch statement
				try {
					List<Customer> customers = cdb.getCustomers();
					for(Customer c: customers) {
						String firstName = c.getFirstName();
						String lastName = c.getLastName();
						String email = c.getEmail();
						System.out.println(email + "\t" + firstName + "\t\t" + lastName + "\t");
						
					}
				} catch (SQLException e) {
					System.out.println("Exception occurred getting all of the customers.");
					e.printStackTrace();
				}
			}
			else if(choice.equalsIgnoreCase("exit")) {
				System.out.println("Thank you for using the customer app\nGoodbye!");
			}
			
		
		}
	}
	
	private static void getMenu() {
		System.out.println(); // new line for space
		System.out.println("COMMAND MENU");
		System.out.println("list - List all customers");
		System.out.println("add - add a customer");
		System.out.println("del - Delete a customer");
		System.out.println("help - Show this menu");
		System.out.println("exit - Exit this application");
		System.out.println(); // new line for space
	}
}
