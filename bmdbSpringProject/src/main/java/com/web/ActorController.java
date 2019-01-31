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

import com.business.Actor;
import com.business.ActorRepository;
import com.util.JsonResponse;

@Controller
@RequestMapping(path="/actor")
public class ActorController {

	@Autowired
	private ActorRepository actorRepo;
	
	@GetMapping(path="/")
	public @ResponseBody JsonResponse getAllActors(){
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(actorRepo.findAll());
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		
		return jr;
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody JsonResponse getActor(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Actor> a = actorRepo.findById(id);
			if(a.isPresent()) {
				jr = JsonResponse.getInstance(a);
			}
			else {
				jr = JsonResponse.getInstance(new Exception ("No actor found with ID = " + id));
			}
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping(path="/")
	public @ResponseBody JsonResponse addActor(@RequestBody Actor a) {

		JsonResponse jr = null;
		jr = JsonResponse.getInstance(saveActor(a));
		
		return jr;
	}
	
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse updateActor(@PathVariable int id, @RequestBody Actor a) {
		
		return saveActor(a);
	}
	
	private @ResponseBody JsonResponse saveActor(Actor a) {
		JsonResponse jr = null;
		try {
			actorRepo.save(a);
			jr = JsonResponse.getInstance(a);
		}
		catch(ConstraintViolationException cve) {
			jr = JsonResponse.getInstance(cve.getMessage());
		}
		return jr;
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody JsonResponse removeActor(@PathVariable int id) {
		JsonResponse jr = null;
		Optional<Actor> a = actorRepo.findById(id);
		if(a.isPresent()) {
			actorRepo.deleteById(id);
			jr = JsonResponse.getInstance(a);
		}
		else {
			jr = JsonResponse.getInstance(new Exception());
			jr.setErrors("Delete unsuccessful.");
		}
		return jr;
	}
}
