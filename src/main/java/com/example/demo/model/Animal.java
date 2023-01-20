package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Override
	public String toString() {
		return "Animal [id=" + id + ", color=" + color + ", name=" + name + ", sex=" + sex + ", species=" + species
				+ "]";
	}

	@Column(length = 50)
	@Size(min = 5, max = 50)
	@NotEmpty
	private String color;

	@Column(length = 50)
	@Size(min = 5, max = 50)
	@NotEmpty
	private String name;

	@Column(length = 250)
	@Size(min = 5, max = 250)
	@NotEmpty
	private String sex;

	@ManyToOne // il a une seule espece
	@JoinColumn(name = "species_id")
	private Species species;

	public Animal() {
	}; // constructor vide

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

}
