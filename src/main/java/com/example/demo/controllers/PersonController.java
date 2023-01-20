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

import com.example.demo.model.Person;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.PersonRepository;

import jakarta.validation.Valid;


@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AnimalRepository animalRepository;
	
	@GetMapping("/Person")
	
	public String getPersonList(Model model) {
		
		List<Person> allPersons = (List<Person>) personRepository.findAll();
		
		model.addAttribute("persons",allPersons);
		
		return "list_persons";
		
	}
	
	
	@GetMapping("Person/{id}")
	public String getPersonIdView(@PathVariable("id") Integer id, Model model) {
		
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			model.addAttribute(person.get());
			model.addAttribute("animals",animalRepository.findAll()); //pour le formulaire apparaitre liste des animaux
			return "update_person";
			}
		  return "error";
	}
	
	
	@GetMapping("Person/create")//GET:Affiche la liste
	public String createPerson(Model model) {
		model.addAttribute(new Person());
		model.addAttribute("animals",animalRepository.findAll()); //pour le formulaire apparaitre liste des animaux
		return "create_person";
	}
	
	
	
	
	@GetMapping("Person/update")//GET:affiche page update
	public String updatePerson(@PathVariable("id") Integer id, Model model) {
		Optional<Person> person = personRepository.findById(id);
		if (person.isPresent()) {
			model.addAttribute(person.get());
			model.addAttribute("animals",animalRepository.findAll()); 
			return "list_persons";
			}
		  return "error";
		
	}
	
	//GETMAPPING POUR delete
	@GetMapping("Person/delete/{id}")
	public String delete(@PathVariable("id") Integer id, Model model) {
		Optional<Person> personDelete = this.personRepository.findById(id);
		personDelete.ifPresent(person ->this.personRepository.delete(person));
		return "redirect:/Person";
		}
	
	//POST MAPPING pour creer un person via form
	@PostMapping("Person")//POST http://localhost:8080/person
	public String updatePerson(@Valid Person person, BindingResult result) {
		
		if(result.hasErrors()) {
			return "create_person";
		}
		//on arrive dans methode avc objet person rempli via le form
		System.out.println("personne creer : "+person);
		this.personRepository.save(person);
		return "redirect:/Person";
		
		
		
	}

}
