package com.example.hoteldatabase.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Huonevaraus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long huoneVarausId;
	
	@ManyToOne
	@JoinColumn(name="varausId")
	private Varaus varaus;
	
	@ManyToOne
	@JoinColumn(name="huoneNro")
	private Huone huone;

	private LocalDateTime tuloPvm;
	private LocalDateTime lahtoPvm;
	private int hloMaara;
	private String lisatietoja;
	private int hinta;
	private Boolean maksettu;
	
	public Huonevaraus() {
		super();
	}

	public Huonevaraus(long huoneVarausId, LocalDateTime tuloPvm, LocalDateTime lahtoPvm, int hloMaara,
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

	public Huonevaraus(long huoneVarausId, Varaus varaus, Huone huone, LocalDateTime tuloPvm, LocalDateTime lahtoPvm,
			int hloMaara, String lisatietoja, int hinta, Boolean maksettu) {
		super();
		this.huoneVarausId = huoneVarausId;
		this.varaus = varaus;
		this.huone = huone;
		this.tuloPvm = tuloPvm;
		this.lahtoPvm = lahtoPvm;
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}
	
	public Varaus getVaraus() {
		return varaus;
	}

	public void setVaraus(Varaus varaus) {
		this.varaus = varaus;
	}

	public Huone getHuone() {
		return huone;
	}

	public void setHuone(Huone huone) {
		this.huone = huone;
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
		return "Huonevaraus [huoneVarausId=" + huoneVarausId + ", varaus=" + varaus + ", huone=" + huone + ", tuloPvm="
				+ tuloPvm + ", lahtoPvm=" + lahtoPvm + ", hloMaara=" + hloMaara + ", lisatietoja=" + lisatietoja
				+ ", hinta=" + hinta + ", maksettu=" + maksettu + "]";
	}

	

/*	@Override
	public String toString() {
		return "Huonevaraus [huoneVarausId=" + huoneVarausId + ", tuloPvm=" + tuloPvm + ", lahtoPvm=" + lahtoPvm
				+ ", hloMaara=" + hloMaara + ", lisatietoja=" + lisatietoja + ", hinta=" + hinta + ", maksettu="
				+ maksettu + "]";
	}*/

	
	
}
