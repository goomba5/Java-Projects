package movieRating;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import movieRating.Movie;

public class MovieCollection {
	
	private List<MovieCollection> movies;
	
	public static double getLowestRating(List<Movie> movies) {
		
		double lowestRating = movies.stream()
				.map(m -> m.getRating())
				.reduce(4.0, (a, b) -> Math.min(a, b));
		
		return lowestRating;
	}
	
	public static double getHighestRating(List<Movie> movies) {
		
		double highestRating = movies.stream()
				.map(m -> m.getRating())
				.reduce(0.0, (a, b) -> Math.max(a, b));
		
		return highestRating;
	}
	
	public static double getAverageRating(List<Movie> movies) {
		
		double averageRating = movies.stream()
				.mapToDouble(m -> m.getRating())
				.average().getAsDouble();
		
		return averageRating;
	}
	
	public void getSize(List<Movie> movies) {
		System.out.println(movies.size());
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
