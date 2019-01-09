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
			
			// *** options for the user ***
			
			// list of customers
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
			// add customer
			else if(choice.equalsIgnoreCase("add")){
				
				// prompt user for customer info
				String email = console.getString("Enter customer email address: ");
				String firstName = console.getString("Enter first name: ");
				String lastName = console.getString("Enter last name: ");
				
				// add new customer to Customer object
				Customer c = new Customer(0, firstName, lastName, email);
				
				// within try-catch, print that the customer was successfully added
				try {
					if(cdb.addCustomer(c)) {
						System.out.println(c.getFirstName() + " " + c.getLastName()+ 
										   " was successfully added to the database!");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error adding customer to DB.");
					e.printStackTrace();
				}
			}
			// delete a customer
			else if(choice.equalsIgnoreCase("del")) {
				try {
					// create customers instance
					List<Customer> customers = cdb.getCustomers();
					
					// retrieve user input
					String userInput = console.getString("Enter email for customer to delete: ");
					
						// loop through the customers and delete the matching person
						for(Customer c: customers) {
							if(userInput.equalsIgnoreCase(c.getEmail())) {
								if(cdb.deleteCustomer(c)) {
									System.out.println(c.getFirstName() + " " + c.getLastName() + 
													   " was deleted from the database.");
								}
							}
						}
					}
				 catch (SQLException e) {
					System.out.println("Exception occurred getting the chosen customer.");
					e.printStackTrace();
				}
				
			}
			// exit the application
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
