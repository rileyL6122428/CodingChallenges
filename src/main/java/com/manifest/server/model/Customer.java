package com.manifest.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id 
	@GeneratedValue 
	private Long id;
	
	private String name; 
	private String address;  
	
	
	public Long getId() { return id; } 
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; } 
	public void setNome(String name) { this.name = name; }
	
	public String getAddress() { return address; } 
	public void setAddress(String address) { this.address = address; } 

}
