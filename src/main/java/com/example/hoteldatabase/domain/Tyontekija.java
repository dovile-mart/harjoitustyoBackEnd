package com.example.hoteldatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Tyontekija {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tyontekija_id")
	private Long tyontekijaId;
	
	private String etunimi;
	private String sukunimi;
	private String sposti;
	private String puhelin;
	private String katuosoite;

	@ManyToOne
	@JoinColumn(name="postinumero")
	private Postinumero postinumero;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tyontekija")//(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Varaus> varaukset;
	
	
	
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


	public Tyontekija(String etunimi, String sukunimi, String sposti, String puhelin,
			String katuosoite, Postinumero postinumero){
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sposti = sposti;
		this.puhelin = puhelin;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
	}

	public Tyontekija(String etunimi, String sukunimi, String sposti, String puhelin,
			String katuosoite, Postinumero postinumero, List<Varaus> varaukset) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sposti = sposti;
		this.puhelin = puhelin;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
		this.varaukset = varaukset;
	}

	
	


	public Long getTyontekijaId() {
		return tyontekijaId;
	}


	public void setTyontekijaId(Long tyontekijaId) {
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

	public Postinumero getPostinumero() {
		return postinumero;
	}


	public void setPostinumero(Postinumero postinumero) {
		this.postinumero = postinumero;
	}


	public List<Varaus> getVaraukset() {
		return varaukset;
	}


	public void setVaraukset(List<Varaus> varaukset) {
		this.varaukset = varaukset;
	}



	@Override
	public String toString() {
		return "Tyontekija [tyontekijaId=" + tyontekijaId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", sposti=" + sposti + ", puhelin=" + puhelin + ", katuosoite=" + katuosoite + ", postinumero="
				+ postinumero +  "]";//", varaukset=" + varaukset +
	}


}
