package com.example.hoteldatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Huoneet {
	@Id
	private String huoneNro;
	private String huoneKuvaus;
	private int hinta;
	private Boolean onkoVapaa;	
	
	public Huoneet() {
		super();
	}
	
	public Huoneet(String huoneNro, String huoneKuvaus, int hinta, Boolean onkoVapaa) {
		super();
		this.huoneNro = huoneNro;
		this.huoneKuvaus = huoneKuvaus;
		this.hinta = hinta;
		this.onkoVapaa = onkoVapaa;
	}

	public String getHuoneNro() {
		return huoneNro;
	}
	public void setHuoneNro(String huoneNro) {
		this.huoneNro = huoneNro;
	}
	
	public String getHuoneKuvaus() {
		return huoneKuvaus;
	}

	public void setHuoneKuvaus(String huoneKuvaus) {
		this.huoneKuvaus = huoneKuvaus;
	}
	
	public int getHinta() {
		return hinta;
	}
	
	public void setHinta(int hinta) {
		this.hinta = hinta;
	}
	
	public Boolean getOnkoVapaa() {
		return onkoVapaa;
	}

	public void setOnkoVapaa(Boolean onkoVapaa) {
		this.onkoVapaa = onkoVapaa;
	}

	
	
	
	@Override
	public String toString() {
		return "Huoneet [huoneNro=" + huoneNro + ", huoneKuvaus=" + huoneKuvaus + ", hinta=" + hinta + ", onkoVapaa="
				+ onkoVapaa + "]";
	}
	
	
}
