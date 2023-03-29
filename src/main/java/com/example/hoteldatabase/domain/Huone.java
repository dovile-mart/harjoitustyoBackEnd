package com.example.hoteldatabase.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Huone {
	@Id
	private String huoneNro;
	private String huoneKuvaus;
	private int hinta;
	private boolean onkoVapaa = true;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "huone")
	private List<Huonevaraus> huonevaraukset;
	
	public Huone() {
		super();
	}
	public Huone(String huoneNro, String huoneKuvaus, int hinta) {
		super();
		this.huoneNro = huoneNro;
		this.huoneKuvaus = huoneKuvaus;
		this.hinta = hinta;
	}
	
	public Huone(String huoneNro, String huoneKuvaus, int hinta, boolean onkoVapaa) {
		super();
		this.huoneNro = huoneNro;
		this.huoneKuvaus = huoneKuvaus;
		this.hinta = hinta;
		this.onkoVapaa = onkoVapaa;
	}
	
	public Huone(String huoneNro, String huoneKuvaus, int hinta, boolean onkoVapaa, List<Huonevaraus> huonevaraukset) {
		super();
		this.huoneNro = huoneNro;
		this.huoneKuvaus = huoneKuvaus;
		this.hinta = hinta;
		this.onkoVapaa = onkoVapaa;
		this.huonevaraukset = huonevaraukset;
	}

	public List<Huonevaraus> getHuonevaraukset() {
		return huonevaraukset;
	}

	public void setHuonevaraukset(List<Huonevaraus> huonevaraukset) {
		this.huonevaraukset = huonevaraukset;
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
	
	public boolean getOnkoVapaa() {
		return onkoVapaa;
	}

	public void setOnkoVapaa(boolean onkoVapaa) {
		this.onkoVapaa = onkoVapaa;
	}
/*
	@Override
	public String toString() {
		return "Huone [huoneNro=" + huoneNro + ", huoneKuvaus=" + huoneKuvaus + ", hinta=" + hinta + ", onkoVapaa="
				+ onkoVapaa + ", huonevaraukset=" + huonevaraukset + "]";
	}

*/	
	
	
	@Override
	public String toString() {
		return "Huone [huoneNro=" + huoneNro + ", huoneKuvaus=" + huoneKuvaus + ", hinta=" + hinta + ", onkoVapaa="
				+ onkoVapaa + "]";
	}
	
	
}
