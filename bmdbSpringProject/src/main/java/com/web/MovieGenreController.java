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

import com.business.MovieGenre;
import com.business.MovieGenreRepository;
import com.util.JsonResponse;

@Controller
@RequestMapping(path="/moviegenre")
public class MovieGenreController {

	@Autowired
	private MovieGenreRepository movieGenreRepo;
	
	@GetMapping(path="/")
	public @ResponseBody JsonResponse getAllMovieGenres(){
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(movieGenreRepo.findAll());
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		
		return jr;
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody JsonResponse getMovieGenre(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<MovieGenre> mg = movieGenreRepo.findById(id);
			if(mg.isPresent()) {
				jr = JsonResponse.getInstance(mg);
			}
			else {
				jr = JsonResponse.getInstance(new Exception ("No movie genre found with ID = " + id));
			}
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping(path="/")
	public @ResponseBody JsonResponse addMovieGenre(@RequestBody MovieGenre mg) {

		JsonResponse jr = null;
		jr = JsonResponse.getInstance(saveMovieGenre(mg));
		
		return jr;
	}
	
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse updateMovieGenre(@PathVariable int id, @RequestBody MovieGenre mg) {
		
		return saveMovieGenre(mg);
	}
	
	private @ResponseBody JsonResponse saveMovieGenre(MovieGenre mg) {
		JsonResponse jr = null;
		try {
			movieGenreRepo.save(mg);
			jr = JsonResponse.getInstance(mg);
		}
		catch(ConstraintViolationException cve) {
			jr = JsonResponse.getInstance(cve.getMessage());
		}
		return jr;
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody JsonResponse removeMovieGenre(@PathVariable int id) {
		JsonResponse jr = null;
		Optional<MovieGenre> mg = movieGenreRepo.findById(id);
		if(mg.isPresent()) {
			movieGenreRepo.deleteById(id);
			jr = JsonResponse.getInstance(mg);
		}
		else {
			jr = JsonResponse.getInstance(new Exception());
			jr.setErrors("Delete unsuccessful.");
		}
		return jr;
	}
}
