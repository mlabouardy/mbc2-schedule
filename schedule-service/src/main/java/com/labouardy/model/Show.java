package com.labouardy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Show {
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	private String image;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	private String ksa;
	
	private String eg;
	
	public Show(){}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKsa() {
		return ksa;
	}
	public void setKsa(String ksa) {
		this.ksa = ksa;
	}
	public String getEg() {
		return eg;
	}
	public void setEg(String eg) {
		this.eg = eg;
	}
	
	public String toString(){
		return name;
	}
	
	
}
