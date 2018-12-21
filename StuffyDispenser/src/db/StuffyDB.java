package db;

import java.util.ArrayList;

import util.Console;
import business.Stuffy;

public class StuffyDB {
	
	// create ArrayList that will hold stuffies
	private ArrayList<Stuffy> stuffies = new ArrayList<>();

	public StuffyDB() {
		populateStuffies();
	}
	
	// populateStuffies() method will fill the StuffDB object when created
	private void populateStuffies() {
		stuffies = new ArrayList<>();
		stuffies.add(new Stuffy(1, "Bulbasaur", "Small", "Green"));
		stuffies.add(new Stuffy(2, "Charmander", "Medium", "Red"));
		stuffies.add(new Stuffy(3, "Pikachu", "Large", "Yellow"));
		stuffies.add(new Stuffy(4, "Hitmanchu", "Medium", "Green"));
		stuffies.add(new Stuffy(5, "Ghastly", "Large", "Black"));
		stuffies.add(new Stuffy(6, "Mew", "Small", "Grey"));
		stuffies.add(new Stuffy(7, "Onyx", "Super Large", "Dark Grey"));
		stuffies.add(new Stuffy(8, "Jolteon", "Medium", "Yellow"));
		stuffies.add(new Stuffy(9, "Staryu", "Small", "Orange"));
		stuffies.add(new Stuffy(10, "Blastoise", "Large", "Blue"));
	}
	
	public ArrayList<Stuffy> grabStuffy(){
		return stuffies;
	}
	
	// grabStuffy() method returns the randomly removed stuffy from the populateStuffies instance
	public Stuffy grabStuffy(int random){
		
			for (Stuffy stuffy : stuffies) {
				if(stuffy.getId() == random) {
					stuffies.remove(stuffy);
					return stuffy;
				}
			}
			return null;
	}
	
	// addStuffy method will prompt user for three pieces of data, create new index, and then display confirmation message
	public void addStuffy(Console console, String prompt1, String prompt2, String prompt3){

		// the new ID must increase so that there are no repeating IDs
		// when a new stuffy is added to the list
		
		int newIndex = stuffies.size() + 1;
		
		// prompt user for type, size and color
		String type = console.getString(prompt1);
		
		String size = console.getString(prompt2);
		
		String color = console.getString(prompt3);
		
		stuffies.add(new Stuffy(newIndex, type, size, color));
		
		System.out.println(); // new line for space
		System.out.println("A "+ size + " " + color + " " + type + " has been added!" +
						   "\nThere are now " + newIndex + " Pokemon in the list.");
		
	}

	@Override
	public String toString() {
		return "StuffyDB [stuffies=" + stuffies + "]";
	}
	
	
}
