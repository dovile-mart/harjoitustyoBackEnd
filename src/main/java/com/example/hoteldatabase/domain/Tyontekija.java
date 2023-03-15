package com.example.hoteldatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tyontekija {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long tyontekijaId;
	private String etunimi;
	private String sukunimi;
	private String sposti;
	private String puhelin;
	private String katuosoite;
	//postinumero;
	
	
	public Tyontekija() {
		super();
	}


	public Tyontekija(String etunimi, String sukunimi, String sposti, String puhelin, String katuosoite) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sposti = sposti;
		this.puhelin = puhelin;
		this.katuosoite = katuosoite;
	}


	public long getTyontekijaId() {
		return tyontekijaId;
	}


	public void setId(long tyontekijaId) {
		this.tyontekijaId = tyontekijaId;
	}


	public String getEtunimi() {
		return etunimi;
	}


	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}


	public String getSukunimi() {
		return sukunimi;
	}


	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}


	public String getSposti() {
		return sposti;
	}


	public void setSposti(String sposti) {
		this.sposti = sposti;
	}


	public String getPuhelin() {
		return puhelin;
	}


	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}


	public String getKatuosoite() {
		return katuosoite;
	}


	public void setKatuosoite(String katuosoite) {
		this.katuosoite = katuosoite;
	}




	@Override
	public String toString() {
		return "Tyontekijat [tyontekijaId=" + tyontekijaId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", sposti=" + sposti
				+ ", puhelin=" + puhelin + ", katuosoite=" + katuosoite + "]";
	}
	
	
}
