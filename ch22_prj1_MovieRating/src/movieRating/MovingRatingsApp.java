package movieRating;

import java.util.ArrayList;
import java.util.List;

import util.Console;

public class MovingRatingsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Movie Ratings App!\n");
		
		List<Movie> movies = new ArrayList<>();
		MovieCollection mc = new MovieCollection(movies);
		Console con = new Console();

        movies.add(new Movie("Wonder Woman", 2017, 4.1));
        movies.add(new Movie("Clash of the Titans", 2010, 2.6));
        movies.add(new Movie("Citizen Kane", 1941, 4.9));
        
        String choice = "y";
        int option;
        
        while (choice.equalsIgnoreCase("y")) {
        	
        	getMenu();
        	
        	option = con.getInt("Choose a menu option: ");
        	
        	// add a movie
        	if(option == 1) {
        		System.out.println();
        		int movieNum = con.getInt("How many movies do you want to enter? ");
        		
        		for(int i=1; i <= movieNum; i++) {
        			System.out.println("Movie #" + i);
        			System.out.println("-------------");
        			String title = con.getString("Enter the movie title: ");
        			int year = con.getInt("Enter the year of release: ");
        			double rating = con.getDouble("Enter rating between 1 and 5 (decimals OK): ");
        			System.out.println();
        			
        			movies.add(new Movie(title, year, rating));
        		}
        		System.out.println(movieNum + " movies were added to the database.");
        	}
        	// view top rated movies
        	else if(option == 2) {
        		System.out.println();
        		System.out.println("Movies Rated 4.0 or Higher");
        		System.out.println("--------------------------");
        		List<Movie> highestRating = MovieCollection.getHighestRated(movies, m -> m.getRating() >= 4.0);
        		highestRating.stream()
        			.forEach(str -> System.out.println(str.getTitle() + " " + "("+  str.getYear() + ")" + 
        										   " " + "Rating: " +str.getRating()));
        	}
        	// view most recent movies
        	else if(option == 3) {
        		System.out.println();
        		System.out.println("Movies Released the Last 10 Years");
        		System.out.println("---------------------------------");
        		List<Movie> moviesAfter = MovieCollection.filterMovies(movies, m -> m.getYear() > 2009);
        		moviesAfter.stream()
        		.forEach(str -> System.out.println(str.getTitle()));
        	}
        	if(option == 4) {
        	System.out.println();
	        	System.out.println("List of All Movies");
	        	System.out.println("------------------");
	        	List<Movie> allMovies = MovieCollection.getAllMovies(movies, m -> m != null);
        	}
        	else if(option == 5) {
        		List<Movie> lowestRating = MovieCollection.getLowestRated(movies, m -> m.getRating() < 3.0);
        		List<Movie> highestRating = MovieCollection.getHighestRated(movies, m -> m.getRating() >= 4.0);
        		double averageRating = MovieCollection.getAverageRating(movies);
        		
        		System.out.println();
        		System.out.println("Movie Ratings Data");
        		System.out.println("------------------");
        		System.out.println("Number of movies: " + mc.getSize(movies));
        		System.out.println("Lowest Rating: " + lowestRating.stream()
					    			.map(m -> m.getRating())
					    			.reduce(4.0, (a, b) -> Math.min(a, b)));
        		System.out.println("Highest Rating: " + highestRating.stream()
					    			.map(m -> m.getRating())
					    			.reduce(0.0, (a, b) -> Math.max(a, b)));
        		System.out.println("Average Rating: " + averageRating);
        		
        	}
        	else if(option == 6) {
        		break;
        		
        	}
        	System.out.println();
        	choice = con.getString("Continue? (y/n) ");
        }
		System.out.println("Thank you for using the Movie Ratings App.\nGoodbye!");
	}
	
	public static void getMenu() {
		System.out.println("1 - Enter a movie");
		System.out.println("2 - View top rated movies");
		System.out.println("3 - View most recent movies");
		System.out.println("4 - View All Movies");
		System.out.println("5 - View Ratings Data");
		System.out.println("6 - Quit Application");
		System.out.println();
	}

}
