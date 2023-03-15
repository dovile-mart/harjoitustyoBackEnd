package com.example.hoteldatabase.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Varaus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long varausId;
	
	@ManyToOne
	@JoinColumn(name="asiakasId")
	private Asiakas asiakas;
	
	@ManyToOne
	@JoinColumn(name="tyontekijaId")
	private Tyontekija tyontekija;
	
	private LocalDateTime varausPvm;
	private String lisatietoja;
	private int hinta;
	private boolean maksettu;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "varaus")
	private List<Huonevaraus> huonevaraus;
	
	public Asiakas getAsiakas() {
		return asiakas;
	}

	public void setAsiakas(Asiakas asiakas) {
		this.asiakas = asiakas;
	}

	public Tyontekija getTyontekija() {
		return tyontekija;
	}

	public void setTyontekija(Tyontekija tyontekija) {
		this.tyontekija = tyontekija;
	}

	public List<Huonevaraus> getHuonevaraus() {
		return huonevaraus;
	}

	public void setHuonevaraus(List<Huonevaraus> huonevaraus) {
		this.huonevaraus = huonevaraus;
	}

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

	public Varaus(Long varausId, Asiakas asiakas, Tyontekija tyontekija, LocalDateTime varausPvm, String lisatietoja,
			int hinta, boolean maksettu, List<Huonevaraus> huonevaraus) {
		super();
		this.varausId = varausId;
		this.asiakas = asiakas;
		this.tyontekija = tyontekija;
		this.varausPvm = varausPvm;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
		this.huonevaraus = huonevaraus;
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

	public boolean getMaksettu() {
		return maksettu;
	}

	public void setMaksettu(boolean maksettu) {
		this.maksettu = maksettu;
	}

	@Override
	public String toString() {
		return "Varaus [varausId=" + varausId + ", asiakas=" + asiakas + ", tyontekija=" + tyontekija + ", varausPvm="
				+ varausPvm + ", lisatietoja=" + lisatietoja + ", hinta=" + hinta + ", maksettu=" + maksettu
				+ ", huonevaraus=" + huonevaraus + "]";
	}

/*	@Override
	public String toString() {
		return "Varaus [varausId=" + varausId + ", varausPvm=" + varausPvm + ", lisatietoja=" + lisatietoja
				+ ", hinta=" + hinta + ", maksettu=" + maksettu + "]";
	}*/
	
	
}
