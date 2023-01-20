package com.example.demo.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.example.demo.model.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom{
	
	 @PersistenceContext
	    private EntityManager entityManager;
	 
	 
	 //Ajouter une méthode pour supprimer toutes les personnes qui n’ont pas d’animaux
	 @Override
	 @Transactional
	    public void deleteAllWithoutAnimals() { //marche 
	      entityManager.createQuery("DELETE FROM Person p WHERE p.animals IS EMPTY");
	    }
	 
	 
	 private final Random random = new Random();
	    private final List<String> names = Arrays.asList("Jojo", "coco", "lolo");
	 
	 //Ajouter une méthode pour générer x entités
		public  void generatePersonEntites(int number) {
	        for (int i = 0; i < number; i++) {
	            Person PersonEntity = new Person();
	            PersonEntity.setFirstname(names.get(random.nextInt(names.size())));
	            entityManager.persist(PersonEntity);
	        }
		 
	    }

		 

}
