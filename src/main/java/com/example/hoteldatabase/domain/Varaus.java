package com.example.hoteldatabase.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@Column(name="varaus_id")
	private long varausId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="asiakasId")
//	@Column(name="asiakas_id")
	private Asiakas asiakas;
	
	@ManyToOne
	@JoinColumn(name="tyontekijaId")
//  @Column(name="tyontekija_id")
	private Tyontekija tyontekija;
	
	@Column(name="varaus_pvm")
	private LocalDateTime varausPvm;
	
	private String lisatietoja;
	private int hinta;
	private boolean maksettu;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "varaus")
	private List<Huonevaraus> huonevaraukset;


	
	public Varaus() {
		super();
	}
//riisuttu versio	
	public Varaus( String lisatietoja,
			int hinta, boolean maksettu) {
		super();
//		this.asiakas = asiakas;
	//	this.varausPvm = varausPvm;LocalDateTime varausPvm,
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}
	
	public Varaus(long varausId, Asiakas asiakas, Tyontekija tyontekija, LocalDateTime varausPvm, String lisatietoja,
			int hinta, boolean maksettu, List<Huonevaraus> huonevaraukset) {
		super();
		this.varausId = varausId;
		this.asiakas = asiakas;
		this.tyontekija = tyontekija;
		this.varausPvm = varausPvm;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
		this.huonevaraukset = huonevaraukset;
	}
	
	
	
	public long getVarausId() {
		return varausId;
	}

	public void setVarausId(long varausId) {
		this.varausId = varausId;
	}
	
	
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
				+ ", huonevaraukset=" + huonevaraukset + "]";
	}

	




/*	@Override
	public String toString() {
		return "Varaus [varausId=" + varausId + ", varausPvm=" + varausPvm + ", lisatietoja=" + lisatietoja
				+ ", hinta=" + hinta + ", maksettu=" + maksettu + "]";
	}*/
	
	
}
