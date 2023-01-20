package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Animal;
import com.example.demo.model.Person;
import com.example.demo.model.Species;
import com.example.demo.repository.AnimalRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.PersonRepositoryCustom;
import com.example.demo.repository.PersonRepositoryCustomImpl;
import com.example.demo.repository.SpeciesRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoTp3SpringApplication  {
	
	 
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoTp3SpringApplication.class, args);
		
	}

	 
		 
	

}
