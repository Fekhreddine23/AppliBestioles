package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Species {

	
	@Override
	public String toString() {
		return "Species [id=" + id + ", commonName=" + commonName + ", latinName=" + latinName + "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50) //column reference bdd
	@Size(min=5, max=500)
	@NotEmpty
	private String commonName;
	
	
	@Column(length = 50) //column reference bdd
	@Size(min=5, max=500)
	@NotEmpty
	private String latinName;
	
	
	public Species() {}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCommonName() {
		return commonName;
	}


	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}


	public String getLatinName() {
		return latinName;
	}


	public void setLatinName(String latinName) {
		this.latinName = latinName;
	}
}
