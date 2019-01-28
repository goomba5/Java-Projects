package pokedex.web;


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

import pokedex.business.Pokemon;
import pokedex.business.PokemonRepository;
import pokedex.util.JsonResponse;

@Controller
@RequestMapping(path="/pokemon")
public class PokemonController {

	@Autowired
	private PokemonRepository pokeRepo;
	
	// get all pokemon
	@GetMapping(path="/")
	public @ResponseBody JsonResponse getAllPokemon(){
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(pokeRepo.findAll());
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		
		return jr;
	}
	
	// get method using path variable
	@GetMapping(path="/{id}")
	public @ResponseBody JsonResponse getPokemon(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Pokemon> p = pokeRepo.findById(id);
			if(p.isPresent()) {
				jr = JsonResponse.getInstance(p);
			}
			else {
				jr = JsonResponse.getInstance(new Exception ("No Pokemon found with ID = " + id));
			}
		}
		catch(Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
	}
	
	// add pokemon method
	@PostMapping(path="/")
	public @ResponseBody JsonResponse addNewPokemon(@RequestBody Pokemon p) {

		JsonResponse jr = null;
		jr = JsonResponse.getInstance(savePokemon(p));
		
		return jr;
	}
	
	// update a user
	@PutMapping("/{id}")
	public @ResponseBody JsonResponse updatePokemon(@PathVariable int id, @RequestBody Pokemon p) {
		
		// should be checking to see if user exists first (?)
		return savePokemon(p);
	}
	
	// save a pokemon
	private @ResponseBody JsonResponse savePokemon(Pokemon p) {
		JsonResponse jr = null;
		try {
			pokeRepo.save(p);
			jr = JsonResponse.getInstance(p);
		}
		catch(ConstraintViolationException cve) {
			jr = JsonResponse.getInstance(cve.getMessage());
		}
		return jr;
	}
	
	// remove a pokemon
	@DeleteMapping(path="/{id}")
	public @ResponseBody JsonResponse removePokemon(@PathVariable int id) {
		JsonResponse jr = null;
		Optional<Pokemon> p = pokeRepo.findById(id);
		if(p.isPresent()) {
			pokeRepo.deleteById(id);
			jr = JsonResponse.getInstance(p);
		}
		else {
			jr = JsonResponse.getInstance(new Exception());
			jr.setErrors("Delete unsuccessful.");
		}
		return jr;
	}
}
