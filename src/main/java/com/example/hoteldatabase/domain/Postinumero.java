package com.example.hoteldatabase.domain;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Postinumero {
	
	@Id
	@Size(min=5, max=5, message="Postinumeron pituus pitää olla 5 merkkiä")
	@Column(name="postinumero", length=5)
	private String postinumero;
		
	@NotEmpty(message="Postitoimipaikka ei voi olla tyhjä")
	@Size(min=1, max=50)
	private String postitoimipaikka;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postinumero")
	@JsonIgnore
	private List<Asiakas> asiakkaat;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postinumero")
	@JsonIgnore
	private List<Tyontekija> tyontekijat;

	
	
	public Postinumero() {
		super();
	}


	public Postinumero(String postinumero, String postitoimipaikka) {
		super();
		this.postinumero = postinumero;
		this.postitoimipaikka = postitoimipaikka;
	}


	public Postinumero(String postinumero, String postitoimipaikka, List<Asiakas> asiakkaat,
			List<Tyontekija> tyontekijat) {
		super();
		this.postinumero = postinumero;
		this.postitoimipaikka = postitoimipaikka;
		this.asiakkaat = asiakkaat;
		this.tyontekijat = tyontekijat;
	}



	public String getPostinumero() {
		return postinumero;
	}


	public void setPostinumero(String postinumero) {
		this.postinumero = postinumero;
	}


	public String getPostitoimipaikka() {
		return postitoimipaikka;
	}

	public void setPostitoimipaikka(String postitoimipaikka) {
		this.postitoimipaikka = postitoimipaikka;
	}


	public void setAsiakkaat(List<Asiakas> asiakkaat) {
		this.asiakkaat = asiakkaat;
	}


	public void setTyontekijat(List<Tyontekija> tyontekijat) {
		this.tyontekijat = tyontekijat;
	}


	@Override
	public String toString() {
		return "Postinumero [postinumero=" + postinumero + ", postitoimipaikka=" + postitoimipaikka + "]";
	}

/*
	@Override
	public String toString() {
		return "Postinumero [postinumero=" + postinumero + ", postitoimipaikka=" + postitoimipaikka + ", asiakkaat="
				+ asiakkaat + ", tyontekijat=" + tyontekijat + "]";
	}
*/
	
	
}
