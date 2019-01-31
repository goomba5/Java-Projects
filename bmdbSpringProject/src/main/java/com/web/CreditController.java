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

import com.business.Credit;
import com.business.CreditRepository;
import com.util.JsonResponse;

@Controller
@RequestMapping(path="/credit")
public class CreditController {

	@Autowired
	private CreditRepository creditRepo;
	
	@GetMapping(path="/")
	public @ResponseBody JsonResponse getAllCredit(){
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(creditRepo.findAll());
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		
		return jr;
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody JsonResponse getCredit(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Credit> a = creditRepo.findById(id);
			if(a.isPresent()) {
				jr = JsonResponse.getInstance(a);
			}
			else {
				jr = JsonResponse.getInstance(new Exception ("No credit found with ID = " + id));
			}
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	@PostMapping(path="/")
	public @ResponseBody JsonResponse addCredit(@RequestBody Credit c) {

		JsonResponse jr = null;
		jr = JsonResponse.getInstance(saveCredit(c));
		
		return jr;
	}
	
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse updateCredit(@PathVariable int id, @RequestBody Credit c) {
		
		return saveCredit(c);
	}
	
	private @ResponseBody JsonResponse saveCredit(Credit c) {
		JsonResponse jr = null;
		try {
			creditRepo.save(c);
			jr = JsonResponse.getInstance(c);
		}
		catch(ConstraintViolationException cve) {
			jr = JsonResponse.getInstance(cve.getMessage());
		}
		return jr;
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody JsonResponse removeCredit(@PathVariable int id) {
		JsonResponse jr = null;
		Optional<Credit> c = creditRepo.findById(id);
		if(c.isPresent()) {
			creditRepo.deleteById(id);
			jr = JsonResponse.getInstance(c);
		}
		else {
			jr = JsonResponse.getInstance(new Exception());
			jr.setErrors("Delete unsuccessful.");
		}
		return jr;
	}
}
