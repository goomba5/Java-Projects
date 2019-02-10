package movieRating;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import movieRating.Movie;

public class MovieCollection {
	
	private List<Movie> movies;
	
	public MovieCollection(List<Movie> movies) {
		super();
		this.movies = movies;
	}

	public static void add(Movie m) {
		
	}
	
	// filter movies with condition
	public static List<Movie> filterMovies(List<Movie> movies, Predicate<Movie> condition){
		List<Movie> filteredMovies = new ArrayList<Movie>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				filteredMovies.add(m);
			}
		}
		return filteredMovies;
	}
	
	// get all movies
	public static List<Movie> getAllMovies(List<Movie> movies, Predicate<Movie> condition){
		List<Movie> allMovies = new ArrayList<>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				allMovies.add(m);
			}
		}
		allMovies.stream()
			.forEach(str -> System.out.println(str.getTitle() + " " + "("+  str.getYear() + ")" + 
					 " " + "Rating: " +str.getRating()));
		
		return allMovies;
	}
	
	// get number of movies
	public static int getSize(List<Movie> movies) {
		return movies.size();
	}
	
	// get lowest rated
	public static List<Movie> getLowestRated(List<Movie> movies, Predicate<Movie> condition) {

		List<Movie> lowestRated = new ArrayList<>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				lowestRated.add(m);
			}
		}
		return lowestRated;
	}
	
	// get highest rated
	public static List<Movie> getHighestRated(List<Movie> movies, Predicate<Movie> condition) {
		
		List<Movie> highestRated = new ArrayList<>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				highestRated.add(m);
			}
		}
		return highestRated;
	}
	
	// get average
	public static double getAverageRating(List<Movie> movies) {
		
		double averageRating = movies.stream()
				.mapToDouble(m -> m.getRating())
				.average().getAsDouble();
		
		return averageRating;
	}
	

	@Override
	public String toString() {
		return "MovieCollection [movies=" + movies + "]";
	}
	
}
