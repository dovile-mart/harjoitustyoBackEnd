package com.example.hoteldatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;

@Entity
public class Asiakas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long asiakasId;
	
//	@NotEmpty(message = "Anna etunimi.")
//	@Size(min=2, max=100)
	private String etunimi;

//	@NotEmpty(message = "Anna etunimi.")
//	@Size(min=2, max=100)
	private String sukunimi;
	private String sposti;
	private String puhelin;
	private String katuosoite;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="postinumero")
	private Postinumero postinumero;
	
	@OneToMany(fetch = FetchType.EAGER)//(cascade = CascadeType.ALL, mappedBy = "asiakas") //täämän muutoksen jälkeen alkoi tulostaa asiakaita
	@JsonIgnore
	private List<Varaus> varaukset;		//ja h2-consolessa näkyy ASIAKAS_VARAUKSET -taulu
	
	
	
	public Asiakas() {
		super();
	}


	public Asiakas(String etunimi, String sukunimi, String sposti, String puhelin, String katuosoite) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sposti = sposti;
		this.puhelin = puhelin;
		this.katuosoite = katuosoite;
	}


	public Asiakas(String etunimi, String sukunimi, String sposti, String puhelin, String katuosoite,
			Postinumero postinumero) {//, List<Varaus> varaukset) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.sposti = sposti;
		this.puhelin = puhelin;
		this.katuosoite = katuosoite;
		this.postinumero = postinumero;
//		this.varaukset = varaukset;
	}


	
	public Long getAsiakasId() {
		return asiakasId;
	}


	public void setAsiakasId(Long asiakasId) {
		this.asiakasId = asiakasId;
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
		return "Asiakas [asiakasId=" + asiakasId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", sposti="
				+ sposti + ", puhelin=" + puhelin + ", katuosoite=" + katuosoite + ", postinumero=" + this.getPostinumero()
				+ ", varaukset=" + this.getVaraukset() + "]";
	}


/*
	@Override
	public String toString() {
		return "Asiakas [asiakasId=" + asiakasId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + ", sposti=" + sposti
				+ ", puhelin=" + puhelin + ", katuosoite=" + katuosoite + "]";
	}*/
	
	
	
}
