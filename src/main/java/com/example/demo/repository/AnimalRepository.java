package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Animal;
import com.example.demo.model.Person;
import com.example.demo.model.Species;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {

	 //Requête qui renvoie tous les animaux de la Species fournie en paramètre
	List<Animal> findBySpecies(Species species); // methode findBy
	
	//Requête qui renvoie tous les animaux dont la couleur fait partie de la liste de couleurs fournie
	List<Animal> findByColorIn(List<String> color);
	
	
	//TP5
	//Requête qui renvoie le nombre d’Animaux dont le Sex est égal à la valeur donnée en paramètres
	 @Query("SELECT COUNT(a) FROM Animal a WHERE a.sex = :sex")
	    long countBySex(@Param("sex") String sex);

}
