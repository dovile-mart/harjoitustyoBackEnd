package com.example.hoteldatabase.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Postinumero {
	
	@Id
	private String postinumero;
	private String Postitoimipaikka;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postinumero")
	private List<Asiakas> asiakkaat;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "postinumero")
	private List<Tyontekija> tyontekijat;

	
	public Postinumero() {
		super();
	}


	public Postinumero(String postinumero, String postitoimipaikka) {
		super();
		this.postinumero = postinumero;
		Postitoimipaikka = postitoimipaikka;
	}


	public Postinumero(String postinumero, String postitoimipaikka, List<Asiakas> asiakkaat,
			List<Tyontekija> tyontekijat) {
		super();
		this.postinumero = postinumero;
		Postitoimipaikka = postitoimipaikka;
		this.asiakkaat = asiakkaat;
		this.tyontekijat = tyontekijat;
	}


	public List<Asiakas> getAsiakkaat() {
		return asiakkaat;
	}


	public void setAsiakkaat(List<Asiakas> asiakkaat) {
		this.asiakkaat = asiakkaat;
	}


	public List<Tyontekija> getTyontekijat() {
		return tyontekijat;
	}


	public void setTyontekijat(List<Tyontekija> tyontekijat) {
		this.tyontekijat = tyontekijat;
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
		return "Postinumero [postinumero=" + postinumero + ", Postitoimipaikka=" + Postitoimipaikka + ", asiakkaat="
				+ asiakkaat + ", tyontekijat=" + tyontekijat + "]";
	}


/*	@Override
	public String toString() {
		return "Postinumero [postinumero=" + postinumero + ", Postitoimipaikka=" + Postitoimipaikka + "]";
	}*/
	
	
}
