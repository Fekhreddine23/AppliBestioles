package com.example.demo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Species;

public interface SpeciesRepository extends CrudRepository<Species, Integer>{
	
	
	//Ajouter une requête qui retourne la première Species dont le nom commun est égal 
	//au paramètre fourni (indice : utiliser le mot-clé findFirst)
	Species  findFirstByCommonName(String commonName);
	
	
	//Ajouter une requête qui retourne une liste de Species dont le nom latin 
	//contient le paramètre fourni en ignorant la casse
	List<Species> findByCommonNameIgnoreCase(String latinName);
	
	
	
	
	//TP5
	//Écrire une méthode qui va aller chercher toutes les Species, ordonnées par nom commun ascendant.
	List<Species> findAllByOrderByCommonNameAsc();
	
	
	//• Écrire une méthode qui retourne les Species avec un nom commun LIKE le paramètre fourni
	 List<Species> findByCommonNameContainingIgnoreCase(String commonName);

}
