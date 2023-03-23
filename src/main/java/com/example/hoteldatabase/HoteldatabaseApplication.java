package com.example.hoteldatabase;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hoteldatabase.domain.Asiakas;
import com.example.hoteldatabase.domain.AsiakasRepository;
import com.example.hoteldatabase.domain.Huonevaraus;
import com.example.hoteldatabase.domain.Postinumero;
import com.example.hoteldatabase.domain.PostinumeroRepository;
import com.example.hoteldatabase.domain.Tyontekija;
import com.example.hoteldatabase.domain.TyontekijaRepository;
import com.example.hoteldatabase.domain.Varaus;
import com.example.hoteldatabase.domain.VarausRepository;

@SpringBootApplication
public class HoteldatabaseApplication {

	private static final Logger log = LoggerFactory.getLogger(HoteldatabaseApplication.class);

	@Autowired
	PostinumeroRepository postinumeroRepo;

	@Autowired
	AsiakasRepository asiakasRepo;
	
	@Autowired
	VarausRepository varausRepo;
	
	@Autowired
	TyontekijaRepository tyontekijaRepo;

	public static void main(String[] args) {
		SpringApplication.run(HoteldatabaseApplication.class, args);
	}
/*	@Bean
	public CommandLineRunner demoPostinumerot(PostinumeroRepository postinumeroRepository) {
		return (args) -> {
			log.info("Luodaan demopostinumerot");
			// Postinumero(String postinumero, String postitoimipaikka)
			postinumeroRepository.save(new Postinumero("06100", "Porvoo"));
			postinumeroRepository.save(new Postinumero("06500", "Porvoo"));

			log.info("Haetaan kaikki postinumerot:");
			for (Postinumero postinumero : postinumeroRepository.findAll()) {
				log.info(postinumero.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner demoVaraukset(VarausRepository varausRepository,
			AsiakasRepository asiakasRepo) {
		return (args) -> {

			log.info("Luodaan demovarauksia");
			// Varaus(Asiakas asiakas, Tyontekija tyontekija, LocalDateTime varausPvm, String lisatietoja,int hinta, boolean maksettu, List<Huonevaraus> huonevaraukset)
			varausRepository.save(new Varaus("Lisätietojen kenttä", 159, false));
			//(10-12-2022, "Lisätietojen kenttä", 159, false)
																			
			log.info("Tulostetaan varaukset");
			for (Varaus varaus : varausRepository.findAll()) {
				log.info(varaus.toString());
			}
		};
	}
*/	
	@Bean
	public CommandLineRunner demoAsiakkaat(AsiakasRepository asiakasRepo, TyontekijaRepository tyontekijaRepo, PostinumeroRepository postinumeroRepo, VarausRepository varausRepo) {
		return (args) -> {

			log.info("Luodaan demopostinumerot");
			// Postinumero(String postinumero, String postitoimipaikka)
			postinumeroRepo.save(new Postinumero("06100", "Porvoo"));
			postinumeroRepo.save(new Postinumero("06500", "Porvoo"));

			log.info("Haetaan kaikki postinumerot:");
			for (Postinumero postinumero : postinumeroRepo.findAll()) {
				log.info(postinumero.toString());
			}
			
			log.info("Luodaan demoasiakkaita");
			// Asiakas(String etunimi, String sukunimi, String sposti, String puhelin,
			// String katuosoite, Postinumero postinumero, List<Varaus> varaukset)
			asiakasRepo.save(new Asiakas("Matti", "Meikäläinen", "matti@mail.com", "019-123456", "Pilvikuja 2", postinumeroRepo.findByPostinumero("06500").get(0)));// ,
			asiakasRepo.save(new Asiakas("Joona", "Seppälä", "joona@mail.com", "050-123456", "Pilvitie 13", postinumeroRepo.findByPostinumero("06100").get(0)));

			log.info("Tulostetaan asiakkaat");
			for (Asiakas asiakas : asiakasRepo.findAll()) {
				log.info(asiakas.toString());
			}


			log.info("Luodaan demotyontekijoita");
			// Tyontekija(String etunimi, String sukunimi, String sposti, String puhelin, String katuosoite, Postinumero postinumero, List<Varaus> varaukset)
			tyontekijaRepo.save(new Tyontekija("Seppo", "Seppolainen", "seppo@mail.com", "019-1111111", "Pilvikatu 42", postinumeroRepo.findByPostinumero("06100").get(0)));// ,, varausRepo.findById(0)
			tyontekijaRepo.save(new Tyontekija("Katri", "Kekkilä", "katri@mail.com", "040-1222233", "Hiihtäjäntie 3", postinumeroRepo.findByPostinumero("06500").get(0)));

			log.info("Tulostetaan tyontekijat");
			for (Tyontekija tyontekija : tyontekijaRepo.findAll()) {
				log.info(tyontekija.toString());
			}
			
			
			log.info("Luodaan demovarauksia");
			// Varaus(Asiakas asiakas, Tyontekija tyontekija, LocalDateTime varausPvm, String lisatietoja,int hinta, boolean maksettu, List<Huonevaraus> huonevaraukset)
			//varausRepo.save(new Varaus(asiakasRepo.findAllById(asiakasId).get(1), "Lisätietojen kenttä", 159, false));
//KESKEN!!! 			varausRepo.save(new Varaus(asiakasRepo.findByAsiakasId(1).get(0), ));
			//(10-12-2022, "Lisätietojen kenttä", 159, false)
																			
			log.info("Tulostetaan varaukset");
			for (Varaus varaus : varausRepo.findAll()) {
				log.info(varaus.toString());
			}
		};
	}



}
