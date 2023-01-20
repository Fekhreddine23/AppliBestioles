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
import com.example.demo.model.Person;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.SpeciesRepository;

import jakarta.validation.Valid;

@Controller
public class AnimalController {
	
	
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private SpeciesRepository speciesRepository;
	
	@GetMapping("/Animal")
public String getAnimalList(Model model) {
		
		List<Animal> allAnimals = (List<Animal>) animalRepository.findAll();
		
		model.addAttribute("animals",allAnimals);
		
		return "list_animals";
	
	}
	/*
	@GetMapping("Animal/{id}")
	public String getAnimalIdView(@PathVariable("id") Integer id, Model model) {
		
		Optional<Animal> animal = animalRepository.findById(id);
		if (animal.isPresent()) {
			model.addAttribute(animal.get());
			return "update_animal";
			}
		  return "error";
	}
	*/
	
	@GetMapping("Animal/create")
	public String createAnimal(Model model) {
		model.addAttribute(new Animal());
		model.addAttribute("species",speciesRepository.findAll());
		return "create_animal";
	}
	
	//POST MAPPING pour creer un animal via form
	@PostMapping("Animal")
	public String updateAnimal(@Valid Animal animal, BindingResult result) {
		
		if(result.hasErrors()) {
			return "create_animal";
		}
		System.out.println("animal creer : "+animal);
		this.animalRepository.save(animal);
		return "redirect:/Animal";
	}
	
	
	@GetMapping("Animal/{id}")//GET:affiche page update
	public String updateAnimal(@PathVariable("id") Integer id, Model model) {
		Optional<Animal> animalUpd = animalRepository.findById(id);
		if (animalUpd.isPresent()) {
			model.addAttribute(animalUpd.get());
			model.addAttribute("species",speciesRepository.findAll()); 
			return "update_animal"; //envoi a la page update
			}
		  return "error";
		
	}
	
	
	//GETBMAPPING POUR delete
	@GetMapping("Animal/delete/{id}")
	public String deleteAnimal(@PathVariable("id") Integer id, Model model) {
		Optional<Animal> animalDelete = this.animalRepository.findById(id);
		animalDelete.ifPresent(animal ->this.animalRepository.delete(animal));
		return "redirect:/Animal";
	}

}
