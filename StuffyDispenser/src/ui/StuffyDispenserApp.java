package ui;

import util.Console;
import ui.StuffyDispenserMenu;
import java.util.ArrayList;
import business.Stuffy;
import db.StuffyDB;

public class StuffyDispenserApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// welcome
		System.out.println("Welcome to the Aperture Science Stuffy Dispenser\n");
		
		// create objects
		Console console = new Console();
		StuffyDispenserMenu menu = new StuffyDispenserMenu();
		StuffyDB db = new StuffyDB();
		
		String choice = "y";
		
		while(choice.equalsIgnoreCase("y")) {
			
			// get the menu
			menu.getAppMenu();
			
			// ask user for menu input
			System.out.println(); // new line for space
			int option = console.getInt("Enter menu option: ");
			
			// run one of the menu options
			if (option == 1) {
				ArrayList<Stuffy> stuffies = db.grabStuffy();
				
				int size = stuffies.size();
				
				int stuffyID = (int) (Math.random() * size) + 1;
				Stuffy pick = db.grabStuffy(stuffyID);
				
				System.out.println(); // new line for space
				
				System.out.println("Nice! You caught a " + pick.getSize() + " " + 
								   pick.getColor() + " " + pick.getType() + "!");
			}
			else if(option == 2) {
				db.addStuffy(console, "Enter type: ", "Enter size: ", "Enter color: ");
				
			}
			else if(option == 3) {
				menu.getStuffyMenu();
			}
			
			else if(option == 4) {
				break;
			}
			
		System.out.println(); // new line for space
		choice = console.getString("Continue? (y/n) ");
		}
		System.out.println(); // new line for space
		System.out.println("Thank you for using the Aperture Science Stuffy Dispenser.\nGoodbye!");
	}

}
