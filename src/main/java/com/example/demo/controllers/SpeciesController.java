package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Animal;
import com.example.demo.model.Species;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.SpeciesRepository;

import jakarta.validation.Valid;

@Controller
public class SpeciesController {
	
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@GetMapping("/Species")
public String getSpeciesList(Model model) {
		
		List<Species> allSpecies = (List<Species>) speciesRepository.findAll();
		
		model.addAttribute("species",allSpecies);
		
		return "list_species";
		
	}
	
	
	@GetMapping("Species/{id}")
	public String getSpecieIdView(@PathVariable("id") Integer id, Model model) {
		
		Optional<Species> specie = speciesRepository.findById(id);
		if (specie.isPresent()) {
			model.addAttribute(specie.get());
			return "update_species";
			}
		  return "error";
	}
	
	
	@GetMapping("Species/create")
	public String createSpecie(Model model) {
		model.addAttribute(new Species());
		return "create_species";
	}
	
	
	
	//POST MAPPING pour creer une espece via form
	@PostMapping("Species")//POST http://localhost:8080/person
	public String createSpecies(@Valid Species species,  BindingResult result) {
		
		if(result.hasErrors()) {
			return "create_species";
		}
		
		System.out.println("Species creer : "+species);
		this.speciesRepository.save(species);
		return "redirect:/Species";
	}
	
	//MAJ species
	@GetMapping("Species/update")//GET:affiche page update
	public String updateSpecies(@PathVariable("id") Integer id, Model model) {
		
		Optional<Species> specieUpdate = speciesRepository.findById(id);
		if(specieUpdate.isPresent()) {
			
			model.addAttribute(specieUpdate.get());
			return "list_species";
		}
		  return "errors";
	}
	
	//delete
	@GetMapping("Species/delete/{id}")
	public String deleteSpecies(@PathVariable("id") Integer id, Model model) {
		Optional<Species> specieDelete = speciesRepository.findById(id);
		specieDelete.ifPresent(specie ->this.speciesRepository.delete(specie));
		return "redirect:/Species";
		
	}

}
