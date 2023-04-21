package com.example.hoteldatabase.domain;

import java.time.LocalDate;
//import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
	@Column(name="huonevaraus_id")
	private Long huonevarausId;
	
	@ManyToOne
	@JoinColumn(name="varaus_id")
	private Varaus varaus;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Huone huone;

	@Column(name="tulo_pvm")
	private LocalDate tuloPvm;
	
	@Column(name="lahto_pvm")
	private LocalDate lahtoPvm;
	
	@Column(name="hlo_maara")
	private int hloMaara;
	
	private String lisatietoja;
	private int hinta;
	private boolean maksettu;
	
	
	
	public Huonevaraus() {
		super();
	}
	
	public Huonevaraus(Huone huone, int hloMaara,
			String lisatietoja, int hinta) {
		super();
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
	}
	
	public Huonevaraus(Huone huone, int hloMaara, String lisatietoja, int hinta, boolean maksettu) {
		super();
		this.huone = huone;
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}

	public Huonevaraus(LocalDate tuloPvm, LocalDate lahtoPvm, int hloMaara,
			String lisatietoja, int hinta) {
		super();
		this.tuloPvm = tuloPvm;
		this.lahtoPvm = lahtoPvm;
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
	}

	public Huonevaraus(LocalDate tuloPvm, LocalDate lahtoPvm, int hloMaara,
			String lisatietoja, int hinta, boolean maksettu) {
		super();
		this.tuloPvm = tuloPvm;
		this.lahtoPvm = lahtoPvm;
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}
	
	public Huonevaraus(Huone huone, LocalDate tuloPvm, LocalDate lahtoPvm,
			int hloMaara, String lisatietoja, int hinta, boolean maksettu) {
		super();
		this.huone = huone;
		this.tuloPvm = tuloPvm;
		this.lahtoPvm = lahtoPvm;
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}
	
	public Huonevaraus(Varaus varaus, Huone huone, LocalDate tuloPvm, LocalDate lahtoPvm,
			int hloMaara, String lisatietoja, int hinta, boolean maksettu) {
		super();
		this.varaus = varaus;
		this.huone = huone;
		this.tuloPvm = tuloPvm;
		this.lahtoPvm = lahtoPvm;
		this.hloMaara = hloMaara;
		this.lisatietoja = lisatietoja;
		this.hinta = hinta;
		this.maksettu = maksettu;
	}
	
	
	
	public Long getHuonevarausId() {
		return huonevarausId;
	}

	public void setHuonevarausId(Long huonevarausId) {
		this.huonevarausId = huonevarausId;
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


	public LocalDate getTuloPvm() {
		return tuloPvm;
	}

	public void setTuloPvm(LocalDate tuloPvm) {
		this.tuloPvm = tuloPvm;
	}

	public LocalDate getLahtoPvm() {
		return lahtoPvm;
	}

	public void setLahtoPvm(LocalDate lahtoPvm) {
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

	public boolean getMaksettu() {
		return maksettu;
	}

	public void setMaksettu(boolean maksettu) {
		this.maksettu = maksettu;
	}



@Override
	public String toString() {
		return "Huonevaraus [huonevarausId=" + huonevarausId + ", varaus=" + this.getVaraus() + " huone=" + this.getHuone() + ", tuloPvm=" + tuloPvm + ", lahtoPvm=" + lahtoPvm
				 + ", hloMaara=" + hloMaara + ", lisatietoja=" + lisatietoja + ", hinta=" + hinta + ", maksettu=" + maksettu + "]";
	}
	
	
}
