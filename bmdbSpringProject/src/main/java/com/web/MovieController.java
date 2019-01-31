package com.web;


import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.Movie;
import com.business.MovieRepository;
import com.util.JsonResponse;

@Controller
@RequestMapping(path="/movie")
public class MovieController {

	@Autowired
	private MovieRepository movieRepo;
	
	@GetMapping(path="/")
	public @ResponseBody JsonResponse getAllMovies(){
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(movieRepo.findAll());
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		
		return jr;
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody JsonResponse getMovie(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Movie> m = movieRepo.findById(id);
			if(m.isPresent()) {
				jr = JsonResponse.getInstance(m);
			}
			else {
				jr = JsonResponse.getInstance(new Exception ("No movie found with ID = " + id));
			}
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping(path="/")
	public @ResponseBody JsonResponse addMovie(@RequestBody Movie m) {

		JsonResponse jr = null;
		jr = JsonResponse.getInstance(saveMovie(m));
		
		return jr;
	}
	
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse updateMovie(@PathVariable int id, @RequestBody Movie m) {
		
		return saveMovie(m);
	}
	
	private @ResponseBody JsonResponse saveMovie(Movie m) {
		JsonResponse jr = null;
		try {
			movieRepo.save(m);
			jr = JsonResponse.getInstance(m);
		}
		catch(ConstraintViolationException cve) {
			jr = JsonResponse.getInstance(cve.getMessage());
		}
		return jr;
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody JsonResponse removeMovie(@PathVariable int id) {
		JsonResponse jr = null;
		Optional<Movie> m = movieRepo.findById(id);
		if(m.isPresent()) {
			movieRepo.deleteById(id);
			jr = JsonResponse.getInstance(m);
		}
		else {
			jr = JsonResponse.getInstance(new Exception());
			jr.setErrors("Delete unsuccessful.");
		}
		return jr;
	}
}
