package movieRating;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MovingRatingsAppTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// lowest rated movie test
	public void lowestRatedTest() {
		List<Movie> moviesTest = new ArrayList<>();
		
		moviesTest.add(new Movie("Test", 2019, 4.0));
//		assertEquals(, MovieCollection.getLowestRated(moviesTest), 1.0);
	}
	
	@Test
	// highest rated movie test
	public void highestRatedTest() {
		List<Movie> moviesTest = new ArrayList<>();
		
		moviesTest.add(new Movie("Test", 2019, 0.0));
//		assertEquals(0.0, MovieCollection.getLowestRated(moviesTest), 1.0);
	}

}
