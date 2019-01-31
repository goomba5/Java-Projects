package com.web;


import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.business.Genre;
import com.business.GenreRepository;
import com.util.JsonResponse;

@Controller
@RequestMapping(path="/genre")
public class GenreController {

	@Autowired
	private GenreRepository genreRepo;
	
	@GetMapping(path="/")
	public @ResponseBody JsonResponse getAllGenres(){
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(genreRepo.findAll());
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		
		return jr;
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody JsonResponse getGenre(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Genre> g = genreRepo.findById(id);
			if(g.isPresent()) {
				jr = JsonResponse.getInstance(g);
			}
			else {
				jr = JsonResponse.getInstance(new Exception ("No genre found with ID = " + id));
			}
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping(path="/")
	public @ResponseBody JsonResponse addGenre(@RequestBody Genre g) {

		JsonResponse jr = null;
		jr = JsonResponse.getInstance(saveGenre(g));
		
		return jr;
	}
	
//	@PutMapping("/{id}")
//	public @ResponseBody JsonResponse updateGenre(@PathVariable int id) {
//		
//		return saveGenre(id);
//	}
	
	private @ResponseBody JsonResponse saveGenre(Genre g) {
		JsonResponse jr = null;
		try {
			genreRepo.save(g);
			jr = JsonResponse.getInstance(g);
		}
		catch(ConstraintViolationException cve) {
			jr = JsonResponse.getInstance(cve.getMessage());
		}
		return jr;
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody JsonResponse removeGenre(@PathVariable int id) {
		JsonResponse jr = null;
		Optional<Genre> g = genreRepo.findById(id);
		if(g.isPresent()) {
			genreRepo.deleteById(id);
			jr = JsonResponse.getInstance(g);
		}
		else {
			jr = JsonResponse.getInstance(new Exception());
			jr.setErrors("Delete unsuccessful.");
		}
		return jr;
	}
}
