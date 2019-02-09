package db;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import business.Movie;

public class MovieIOTest {

	@Test
	public void test() {
//		fail("Not yet implemented");
	}
	
	// get all movies test
	@Test
	public void movieDbTest(){
		MovieIO mIO = new MovieIO();
		ArrayList<Movie> tester = mIO.getMovies();
		ArrayList<Movie> movieTestDb = mIO.getMovies();
		
		assertEquals(tester, movieTestDb);
	}

}
