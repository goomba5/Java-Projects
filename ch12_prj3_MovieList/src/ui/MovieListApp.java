package ui;

import java.util.ArrayList;

import business.Movie;
import db.MovieIO;
import util.Console;

public class MovieListApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the Movie List App\n");
		
		Console console = new Console();
		MovieIO mIO = new MovieIO();
		
		String choice = "y";
		
		// tell user how many movies are available
		
		while(choice.equalsIgnoreCase("y")) {
			System.out.println("Choose from " + mIO.getMovies().size() + " movies.");
			System.out.println("Categories: drama | musical | scifi | horror | comedy | animated");
		
			String category = console.getString("Enter a category: ");
			
			ArrayList<Movie> filteredMovies = mIO.getMovies(category);
			
			for(Movie m : filteredMovies) {
				System.out.println(m.getTitle());
			}
			
		// continue
		choice = console.getString("Continue? (y/n) ");
		}
		// goodbye
		System.out.println("Thank you for using the Movie List App\nGoodbye!");
	}

}
