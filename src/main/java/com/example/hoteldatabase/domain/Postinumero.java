package com.example.hoteldatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Postinumero {
	
	@Id
	private String postinumero;
	private String Postitoimipaikka;


	public Postinumero() {
		super();
	}


	public Postinumero(String postinumero, String postitoimipaikka) {
		super();
		this.postinumero = postinumero;
		Postitoimipaikka = postitoimipaikka;
	}


	public String getPostinumero() {
		return postinumero;
	}


	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}


	public String getPostitoimipaikka() {
		return Postitoimipaikka;
	}


	public void setPostitoimipaikka(String postitoimipaikka) {
		Postitoimipaikka = postitoimipaikka;
	}


	@Override
	public String toString() {
		return "Postinumerot [postinumero=" + postinumero + ", Postitoimipaikka=" + Postitoimipaikka + "]";
	}
	
	
}
