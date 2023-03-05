package com.example.hoteldatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asiakkaat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long asiakasId;
	private String etunimi;
	private String sukunimi;
	private String sposti;
	private String puhelin;
	private String katuosoite;
	//postinumero;
	
	
	public Asiakkaat() {
		super();
	}


	public Asiakkaat(String etunimi, String sukunimi, String sposti, String puhelin, String katuosoite) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sposti = sposti;
		this.puhelin = puhelin;
		this.katuosoite = katuosoite;
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
		return "Asiakkaat [asiakasId=" + asiakasId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", sposti=" + sposti
				+ ", puhelin=" + puhelin + ", katuosoite=" + katuosoite + "]";
	}
	
	
	
}
