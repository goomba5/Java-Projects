package ui;

import java.util.ArrayList;

import business.Stuffy;
import db.StuffyDB;

public class StuffyDispenserMenu {
	StuffyDB db = new StuffyDB();
	ArrayList<Stuffy> stuffyMenu = db.grabStuffy();
	
	// display the list of options available to the user
	public void getAppMenu() {
		System.out.println("Stuffy Menu\n");
		
		System.out.println("1 - Grab Stuffy" + "\n" + 
						   "2 - Add Stuffy" + "\n" +
						   "3 - Show Current List of Stuffies" + "\n" +
						   "4 - Exit");
	}
	
	public void getStuffyMenu() {
		System.out.println(); // new line for space
			System.out.println("Current List:");
			for (Stuffy stuffy : stuffyMenu) {
				System.out.print(stuffy.getType() + "\n");
			}
		}
	}
