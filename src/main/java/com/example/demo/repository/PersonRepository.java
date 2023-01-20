package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> , PersonRepositoryCustom{
	
	
	//Requête qui retourne les personnes ayant pour nom le premier paramètre fourni 
	//ou ayant pour prénom le second paramètre fourni
	
	List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
	
	
	//Requête qui retourne toutes les personnes d’un âge supérieur ou égal au paramètre fourni
	List<Person>  findByAgeGreaterThanEqual(Integer age);
	
	
	//TP5
	//Écrire une méthode qui va chercher les Personnes dont l’âge est entre « age min » et « age max ».
	@Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
    List<Person> findByAgeBetween(@Param("ageMin") int ageMin, @Param("ageMax") int ageMax);

}
