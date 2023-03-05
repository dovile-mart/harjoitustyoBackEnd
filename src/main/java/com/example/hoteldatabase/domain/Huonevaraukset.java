package com.example.hoteldatabase.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Huonevaraukset {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long huoneVarausId;
	//varausId;
	//huoneNro;
	private LocalDateTime tuloPvm;
	private LocalDateTime lahtoPvm;
	private int hloMaara;
	private String lisatietoja;
	private int hinta;
	private Boolean maksettu;
	
	public Huonevaraukset() {
		super();
	}

	public Huonevaraukset(long huoneVarausId, LocalDateTime tuloPvm, LocalDateTime lahtoPvm, int hloMaara,
			String lisatietoja, int hinta, Boolean maksettu) {
		super();
		this.huoneVarausId = huoneVarausId;
		this.tuloPvm = tuloPvm;
		this.lahtoPvm = lahtoPvm;
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}

	public long getHuoneVarausId() {
		return huoneVarausId;
	}

	public void setHuoneVarausId(long huoneVarausId) {
		this.huoneVarausId = huoneVarausId;
	}

	public LocalDateTime getTuloPvm() {
		return tuloPvm;
	}

	public void setTuloPvm(LocalDateTime tuloPvm) {
		this.tuloPvm = tuloPvm;
	}

	public LocalDateTime getLahtoPvm() {
		return lahtoPvm;
	}

	public void setLahtoPvm(LocalDateTime lahtoPvm) {
		this.lahtoPvm = lahtoPvm;
	}

	public int getHloMaara() {
		return hloMaara;
	}

	public void setHloMaara(int hloMaara) {
		this.hloMaara = hloMaara;
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
		return "Huonevaraukset [huoneVarausId=" + huoneVarausId + ", tuloPvm=" + tuloPvm + ", lahtoPvm=" + lahtoPvm
				+ ", hloMaara=" + hloMaara + ", lisatietoja=" + lisatietoja + ", hinta=" + hinta + ", maksettu="
				+ maksettu + "]";
	}

	
	
}
