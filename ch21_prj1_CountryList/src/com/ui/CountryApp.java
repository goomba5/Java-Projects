package com.ui;

import java.sql.SQLException;
import java.util.List;
import com.db.CountryDB;

import business.Country;
import util.Console;

public class CountryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Country Manager Thingy\n");
		
		Console console = new Console();
		CountryDB cdb = new CountryDB();
		
		int choice = 0;
		
		while(choice != 3) {
			
			// get the menu
			getMenu();
			
			// retrieve user input
			choice = console.getInt("Enter menu number: ", 0, 4);
			
			if(choice == 1) {
					System.out.println("List of countries: \n");
					
					// call the DB to get the list of countries
					// must be wrapped in try-catch statement
					try {
						List<Country> countries = cdb.getCountries();
						for(Country c: countries) {
							System.out.println(c.toString());
						}
					} catch (SQLException e) {
						System.out.println("Exception occurred getting all stuffies.");
						e.printStackTrace();
					}
				}
			}
			System.out.println(); // new line for space
			System.out.println("Thank you for using the Country Managing App Mobobber.\nGoodbye!");
			
		}
	
	private static void getMenu() {
		System.out.println(); // new line for space
		System.out.println("1 - List countries");
		System.out.println("2 - Add a country");
		System.out.println("3 - Exit");
	}
}
