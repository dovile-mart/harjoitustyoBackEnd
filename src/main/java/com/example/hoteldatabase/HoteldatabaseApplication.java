package com.example.hoteldatabase;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hoteldatabase.domain.Asiakas;
import com.example.hoteldatabase.domain.AsiakasRepository;
import com.example.hoteldatabase.domain.Huone;
import com.example.hoteldatabase.domain.HuoneRepository;
import com.example.hoteldatabase.domain.Huonevaraus;
import com.example.hoteldatabase.domain.HuonevarausRepository;
import com.example.hoteldatabase.domain.AppUser;
import com.example.hoteldatabase.domain.AppUserRepository;
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

	@Autowired
	HuoneRepository huoneRepo;
	
	@Autowired
	HuonevarausRepository huonevarausRepo;
	
	@Autowired
	AppUserRepository appuserRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HoteldatabaseApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoData(AsiakasRepository asiakasRepo, TyontekijaRepository tyontekijaRepo, 
			PostinumeroRepository postinumeroRepo, VarausRepository varausRepo, HuoneRepository huoneRepo,
			HuonevarausRepository huonevarausRepo, AppUserRepository appuserRepo) {
		return (args) -> {

			log.info("Luodaan postinumerot");
			// Postinumero(String postinumero, String postitoimipaikka)
			postinumeroRepo.save(new Postinumero("06100", "Porvoo"));
			postinumeroRepo.save(new Postinumero("06500", "Porvoo"));
			postinumeroRepo.save(new Postinumero("05500", "Helsinki"));
			postinumeroRepo.save(new Postinumero("02300", "Tampere"));
			log.info("Haetaan kaikki postinumerot:");
			for (Postinumero postinumero : postinumeroRepo.findAll()) {
				log.info(postinumero.toString());
			}
			
						
			log.info("Luodaan huoneita");
			//String huoneNro, String huoneKuvaus, int hinta, boolean onkoVapaa
			huoneRepo.save(new Huone("101", "Huoneen 101 kuvaus", 90, true));
			huoneRepo.save(new Huone("102", "Huoneen 102 kuvaus", 110, true));
			huoneRepo.save(new Huone("103", "Huoneen 103 kuvaus", 95, true));
			log.info("Tulostetaan huoneet:");
			for (Huone huone : huoneRepo.findAll()) {
				log.info(huone.toString());
			}
			
			
			log.info("Luodaan asiakkaita");
			// Asiakas(String etunimi, String sukunimi, String sposti, String puhelin, String katuosoite, Postinumero postinumero, List<Varaus> varaukset)
			asiakasRepo.save(new Asiakas("Matti", "Meikäläinen", "matti@mail.com", "019-123456", "Pilvikuja 2", postinumeroRepo.findByPostinumero("06500").get(0)));//, varausRepo.findByVarausId(1).get(0)));// ,
			asiakasRepo.save(new Asiakas("Joona", "Seppälä", "joona@mail.com", "050-123456", "Pilvitie 13", postinumeroRepo.findByPostinumero("06100").get(0)));
			asiakasRepo.save(new Asiakas("Katri", "Seppälä", "katri@mail.com", "050-123666", "Pilvitie 13", postinumeroRepo.findByPostinumero("06100").get(0)));
			log.info("Tulostetaan asiakkaat:");
			for (Asiakas asiakas : asiakasRepo.findAll()) {
				log.info(asiakas.toString());
			}
					
			
			log.info("Luodaan työntekijöitä");
			// Tyontekija(String etunimi, String sukunimi, String sposti, String puhelin, String katuosoite, Postinumero postinumero, List<Varaus> varaukset)
			tyontekijaRepo.save(new Tyontekija("Seppo", "Seppolainen", "seppo@mail.com", "019-1111111", "Pilvikatu 42", postinumeroRepo.findByPostinumero("06100").get(0)));// ,, varausRepo.findById(0)
			tyontekijaRepo.save(new Tyontekija("Katri", "Kekkilä", "katri@mail.com", "040-1222233", "Hiihtäjäntie 3", postinumeroRepo.findByPostinumero("06500").get(0)));
			tyontekijaRepo.save(new Tyontekija("Antti", "Opiskelija", "antti@mail.com", "040-000000", "Opiskelijakatu 15-5", postinumeroRepo.findByPostinumero("02300").get(0)));
			log.info("Tulostetaan tyontekijat:");
			for (Tyontekija tyontekija : tyontekijaRepo.findAll()) {
				log.info(tyontekija.toString());
			}
			
/*			huonevarausRepo.save(new Huonevaraus(huoneRepo.findByHuoneNro("101").get(0), LocalDate.of(2023, 1, 23), LocalDate.of(2023, 1, 24), 2, "Lisätiedot huoneen 101 huonevarauksesta", 120, false)); 
			log.info("Tulostetaan huonevaraus");
			for (Huonevaraus huonevaraus : huonevarausRepo.findAll()) {
				log.info(huonevaraus.toString());
			}

			varausRepo.save(new Varaus(huonevarausRepo.findByHuone(huoneRepo.findByHuoneNro("101").get(0)).get(0)));
			varausRepo.save(new Varaus(asiakasRepo.findByEtunimi("Joona").get(0), tyontekijaRepo.findByEtunimi("Katri").get(0), LocalDate.of(2023, 1, 24), "Lisätiedot varauksesta", 150, false, huonevarausRepo.findByHuone(huoneRepo.findByHuoneNro("101").get(0)).get(0)));
*/			
			
			
			
			log.info("Luodaan varauksia");
			//Varaus(Asiakas asiakas, Tyontekija tyontekija, LocalDate varausPvm, String lisatietoja, int hinta, boolean maksettu,List<Huonevaraus> huonevaraukset))
			varausRepo.save(new Varaus(asiakasRepo.findByEtunimi("Matti").get(0), tyontekijaRepo.findByEtunimi("Seppo").get(0), LocalDate.of(2023, 1, 23), "Lisätiedot varauksesta", 150, false));//, huonevarausRepo.findByHuone(huoneRepo.findByHuoneNro("101").get(0))));
			varausRepo.save(new Varaus(asiakasRepo.findByEtunimi("Joona").get(0), tyontekijaRepo.findByEtunimi("Katri").get(0), LocalDate.of(2023, 1, 24), "Lisätiedot varauksesta", 150, false));//, huonevarausRepo.findByHuone(null)));
			varausRepo.save(new Varaus(asiakasRepo.findByEtunimi("Matti").get(0), tyontekijaRepo.findByEtunimi("Katri").get(0), LocalDate.of(2023, 1, 26), "Lisätiedot varauksesta", 120, false));//, huonevarausRepo.findByHuone(null)));
			log.info("Tulostetaan varaukset");
			for (Varaus varaus : varausRepo.findAll()) {
				log.info(varaus.toString());
			}
			
					
			log.info("Luodaan huonevarauksia");
			//public Huonevaraus(Varaus varaus, Huone huone, LocalDate tuloPvm, LocalDate lahtoPvm,	int hloMaara, String lisatietoja, int hinta, boolean maksettu)
//			Asiakas a = asiakasRepo.findByEtunimi("Matti").get(0);
//			Tyontekija t = tyontekijaRepo.findByEtunimi("Seppo").get(0);
//			log.info("Asiakas: " + a);
//			log.info("Tyontekija: " + t);
//			Varaus v = varausRepo.findByAsiakasAndTyontekija(a, t).get(0);
//			log.info("varaus: " + v);
//			varausRepo.findByAsiakasAndTyontekija(asiakasRepo.findByEtunimi("Matti").get(0), tyontekijaRepo.findByEtunimi("Seppo").get(0)).get(0), 
					
			huonevarausRepo.save(new Huonevaraus(varausRepo.findByAsiakasAndTyontekija(asiakasRepo.findByEtunimi("Matti").get(0),
					tyontekijaRepo.findByEtunimi("Seppo").get(0)).get(0), huoneRepo.findByHuoneNro("101").get(0), 
					LocalDate.of(2023, 1, 23), LocalDate.of(2023, 1, 24), 2, "Lisätiedot huoneen 101 huonevarauksesta",	120, false)); 
					
			huonevarausRepo.save(new Huonevaraus(varausRepo.findByAsiakasAndTyontekija(asiakasRepo.findByEtunimi("Joona").get(0), 
					tyontekijaRepo.findByEtunimi("Katri").get(0)).get(0), huoneRepo.findByHuoneNro("103").get(0), 
					LocalDate.of(2023, 1, 23), LocalDate.of(2023, 1, 25), 1, "Lisätiedot huoneen 103 huonevarauksesta", 90, true)); 
				
			huonevarausRepo.save(new Huonevaraus(varausRepo.findByAsiakasAndTyontekija(asiakasRepo.findByEtunimi("Matti").get(0), 
					tyontekijaRepo.findByEtunimi("Seppo").get(0)).get(0), huoneRepo.findByHuoneNro("101").get(0), 
						LocalDate.of(2023, 1, 23), LocalDate.of(2023, 1, 24), 2, "Lisätiedot huoneen 101 huonevarauksesta", 130, false));					
				
				log.info("Tulostetaan huonevaraukset");
				for (Huonevaraus huonevaraus : huonevarausRepo.findAll()) {
					log.info(huonevaraus.toString());
				}
			

	
				log.info("Luodaan käyttäjät"); //user-user, admin-admin
				//Kayttaja(String kaytnimi, String salasanaHash, String rooli)
				AppUser user1= new AppUser("user", "$2a$10$az.JwzryQNSAkKPFnjEtAeQvfjz2/DkRsXMoIEQUuOyQTIk3Gsmbq", "USER");
				AppUser user2 = new AppUser("admin", "$2a$10$jHZtCgwiHJZhaWfj5dShOOtdovGkgrQqtFrAX9a/yJxy9HktsT7TK", "ADMIN");
				appuserRepo.save(user1);
				appuserRepo.save(user2);
		};	

	}

}
