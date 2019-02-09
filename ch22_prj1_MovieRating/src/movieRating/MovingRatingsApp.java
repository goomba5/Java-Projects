package movieRating;

import java.util.ArrayList;
import java.util.List;

public class MovingRatingsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Movie Ratings App!\n");
		
		MovieCollection mc = new MovieCollection();
		List<Movie> movies = new ArrayList<>();

        // add some starting data to make testing easier
        movies.add(new Movie("Wonder Woman", 2017, 4.1));
        movies.add(new Movie("Clash of the Titans", 2010, 2.6));
        movies.add(new Movie("Citizen Kane", 1941, 4.9));
        
        System.out.println(movies);
		
        double lowestRating = MovieCollection.getLowestRating(movies);
        double highestRating = MovieCollection.getHighestRating(movies);
        double averageRating = MovieCollection.getAverageRating(movies);
        
        List<Movie> moviesAfter = MovieCollection.filterMovies(movies, m -> m.getYear() > 2010);
        List<Movie> moviesBefore = MovieCollection.filterMovies(movies, m -> m.getYear() < 2010);
        
        System.out.println("Lowest Rated Movie: " + lowestRating);
        System.out.println("Highest Rated Movie: " + highestRating);
        System.out.println("Average Rating for a Movie: " + averageRating);
        
        System.out.println("Movies After 2010: " + moviesAfter);
        System.out.println("Movies Before 2010: " + moviesBefore);
		
		System.out.println("Gooooodbyyyyyyyyyyye");
	}

}
