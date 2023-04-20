package com.example.hoteldatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Huone {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Anna huonenumero.")
	@Column(name="huone_nro")
	private String huoneNro;

	@NotEmpty(message = "Anna kuvaus.")
	@Size(max=150, message = "Maksimi pituus 150 merkkiä.")
	@Column(name="huone_kuvaus")
	private String huoneKuvaus;
	
	@Min(value = 0, message = "Hinta ei voi olla negatiivinen luku")
	private int hinta;
	
	@Column(name="onko_vapaa")
	private boolean onkoVapaa = true;	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "huone")
	@JsonIgnore
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


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public boolean isOnkoVapaa() {
		return onkoVapaa;
	}
	public void setOnkoVapaa(boolean onkoVapaa) {
		this.onkoVapaa = onkoVapaa;
	}
	public List<Huonevaraus> getHuonevaraukset() {
		return huonevaraukset;
	}
	public void setHuonevaraukset(List<Huonevaraus> huonevaraukset) {
		this.huonevaraukset = huonevaraukset;
	}
	@Override
	public String toString() {
		return "Huone [id=" + id + ", huoneNro=" + huoneNro + ", huoneKuvaus=" + huoneKuvaus + ", hinta=" + hinta
				+ ", onkoVapaa=" + this.isOnkoVapaa() +  "]";
	}

	
	
}
