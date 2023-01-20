package com.example.demo.model;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
public class Person {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Max(120)
	@Min(0)
	private Integer age;
	
	@Column(length = 50) //column reference bdd
	@Size(max = 50)
	@NotEmpty
	private String firstname;
	
	
	@Column(length = 50) 
	@Size(max = 50)
	@NotEmpty
	private String lastname;
	
	@ManyToMany
	@JoinTable(
	  name = "person_animals", 
	  joinColumns = @JoinColumn(name = "person_id"), 
	  inverseJoinColumns = @JoinColumn(name = "animals_id"))
	private List<Animal> animals = new ArrayList<Animal>();

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Person() { //constructor vide
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", animals=" + animals + "]";
	}

	public void setFirstname(String fName) {
		this.firstname = fName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lName) {
		this.lastname = lName;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
