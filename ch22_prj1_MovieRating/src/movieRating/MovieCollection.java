package movieRating;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import movieRating.Movie;

public class MovieCollection {
	
	private List<MovieCollection> movies;
	
	public MovieCollection(List<MovieCollection> movies) {
		super();
		this.movies = movies;
	}

	public static List<Movie> getAllMovies(List<Movie> movies, Predicate<Movie> condition){
		List<Movie> allMovies = new ArrayList<>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				allMovies.add(m);
			}
		}
		allMovies.stream()
		.forEach(str -> System.out.println(str.getTitle() + ", " + str.getRating()));
		
		return allMovies;
	}
	
	public static void add(Movie m) {
	}
	
	public static void getSize(List<Movie> movies) {
		System.out.println(movies.size());
	}
	
	public static List<Movie> getLowestRated(List<Movie> movies, Predicate<Movie> condition) {

		List<Movie> lowestRated = new ArrayList<>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				lowestRated.add(m);
			}
		}
		return lowestRated;
	}
	
	public static List<Movie> getHighestRated(List<Movie> movies, Predicate<Movie> condition) {
		
		List<Movie> highestRated = new ArrayList<>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				highestRated.add(m);
			}
		}
		return highestRated;
	}
	
	public static double getAverageRating(List<Movie> movies) {
		
		double averageRating = movies.stream()
				.mapToDouble(m -> m.getRating())
				.average().getAsDouble();
		
		return averageRating;
	}
	
	public static List<Movie> filterMovies(List<Movie> movies, Predicate<Movie> condition){
		List<Movie> filteredMovies = new ArrayList<Movie>();
		
		for(Movie m: movies) {
			if(condition.test(m)) {
				filteredMovies.add(m);
			}
		}
		return filteredMovies;
	}

	@Override
	public String toString() {
		return "MovieCollection [movies=" + movies + "]";
	}
	
}
