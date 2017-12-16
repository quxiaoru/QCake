package com.qxr.cakeshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="flavour")
public class Flavour {

	private int id; 
	private String flavourName;
	@Id
	@GeneratedValue(generator="my")
	@GenericGenerator(name="my",strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlavourName() {
		return flavourName;
	}
	public void setFlavourName(String flavourName) {
		this.flavourName = flavourName;
	}
	
}
