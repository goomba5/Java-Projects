package movieRating;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class MovingRatingsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Movie Ratings App!\n");

		List<Movie> movies = new ArrayList<>();
		Console con = new Console();

        movies.add(new Movie("Wonder Woman", 2017, 4.1));
        movies.add(new Movie("Clash of the Titans", 2010, 2.6));
        movies.add(new Movie("Citizen Kane", 1941, 4.9));
        
        String choice = "y";
        int option;
        
        while (choice.equalsIgnoreCase("y")) {
        	
        	getMenu();

        	option = con.getInt("Enter an option: ");
        	
        	if(option == 1) {
        	System.out.println();
        	System.out.println("All Movies:");
        	List<Movie> allMovies = MovieCollection.getAllMovies(movies, m -> m != null);
        	
        	}
        	
        	else if(option == 2) {
        		System.out.println();
        		MovieCollection.getSize(movies);
        		
        	}
        	// add a movie
        	else if(option == 3) {
        		System.out.println();
        		String title = con.getString("Enter the movie title: ");
        		int year = con.getInt("Enter the year of release: ");
        		double rating = con.getDouble("Enter the movie rating: ");
        		Movie m = new Movie(title, year, rating);
        		
        		movies.add(m);
        		System.out.println("A new movie has been added to the database.");
        	}
        	else if(option == 4) {
        		System.out.println();
        		List<Movie> lowestRating = MovieCollection.getLowestRated(movies, m -> m.getRating() < 3.0);
        		System.out.println("Lowest Rated Movies: " + lowestRating);
        		
        	}
        	else if(option == 5) {
        		System.out.println();
        		List<Movie> highestRating = MovieCollection.getHighestRated(movies, m -> m.getRating() > 3.0);
        		System.out.println("Highest Rated Movies: " + highestRating);
        		
        	}
        	else if(option == 6) {
        		System.out.println();
        		double averageRating = MovieCollection.getAverageRating(movies);
        		System.out.println("Average Rating for a Movie: " + averageRating);
        		
        	}
        	else if(option == 7) {
        		System.out.println();
        		List<Movie> moviesAfter = MovieCollection.filterMovies(movies, m -> m.getYear() > 2010);
        		System.out.println("Movies After 2010: " + moviesAfter);
        		
        	}
        	else if(option == 8) {
        		System.out.println();
        		List<Movie> moviesBefore = MovieCollection.filterMovies(movies, m -> m.getYear() < 2010);
        		System.out.println("Movies Before 2010: " + moviesBefore);
        		
        	}
        	System.out.println();
        	choice = con.getString("Continue? (y/n) ");
        }
		System.out.println("Gooooodbyyyyyyyyyyye");
	}
	
	public static void getMenu() {
		System.out.println("1 - View all movies");
		System.out.println("2 - Number of Movies in the List");
		System.out.println("3 - Add a movie");
		System.out.println("4 - Lowest Rated Movies");
		System.out.println("5 - Highest Rated Movies");
		System.out.println("6 - Average Movie Rating");
		System.out.println("7 - Movies Before 2010");
		System.out.println("8 - Movies After 2010");
		System.out.println();
	}

}
