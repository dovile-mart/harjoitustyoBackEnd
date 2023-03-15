package com.example.hoteldatabase.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Varaus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long varausId;
	//asiakasId
	//tyontekijaId
	private LocalDateTime varausPvm;
	private String lisatietoja;
	private int hinta;
	private Boolean maksettu;
	
	public Varaus() {
		super();
	}
	
	public Varaus(Long varausId, LocalDateTime varausPvm, String lisatietoja, int hinta, Boolean maksettu) {
		super();
		this.varausId = varausId;
		this.varausPvm = varausPvm;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}

	public Long getVarausId() {
		return varausId;
	}

	public void setVarausId(Long varausId) {
		this.varausId = varausId;
	}

	public LocalDateTime getVarausPvm() {
		return varausPvm;
	}

	public void setVarausPvm(LocalDateTime varausPvm) {
		this.varausPvm = varausPvm;
	}

	public String getLisatietoja() {
		return lisatietoja;
	}

	public void setLisatietoja(String lisatietoja) {
		this.lisatietoja = lisatietoja;
	}

	public int getHinta() {
		return hinta;
	}

	public void setHinta(int hinta) {
		this.hinta = hinta;
	}

	public Boolean getMaksettu() {
		return maksettu;
	}

	public void setMaksettu(Boolean maksettu) {
		this.maksettu = maksettu;
	}

	@Override
	public String toString() {
		return "Varaukset [varausId=" + varausId + ", varausPvm=" + varausPvm + ", lisatietoja=" + lisatietoja
				+ ", hinta=" + hinta + ", maksettu=" + maksettu + "]";
	}
	
	
}
