package com.cg.insurance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int id;
	private String city;
	
	//Constructors
	public Address() {}
	public Address(String city) {
		this.city = city;
	}
	
}
