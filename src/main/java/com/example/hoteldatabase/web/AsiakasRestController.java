package com.example.hoteldatabase.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hoteldatabase.domain.Asiakas;
import com.example.hoteldatabase.domain.AsiakasRepository;


@RestController
public class AsiakasRestController {
	private static final Logger log = LoggerFactory.getLogger(AsiakasRestController.class);

	
	@Autowired
	AsiakasRepository asiakasRepo;
	
	
	//hakee kaikki asiakkaat
	@GetMapping("api/asiakkaat")
	public Iterable<Asiakas> getAsiakkaat(){
		log.info("Haetaan kaikki asiakkaat:");
		return asiakasRepo.findAll();
	}
	
	//hakee yhden asiakkaan tiedot
	@GetMapping("api/asiakkaat/{asiakasId}")
	Optional<Asiakas> getAsiakas(@PathVariable Long asiakasId) {
		log.info("Hae asiakas id:llä: " + asiakasId);
		return asiakasRepo.findById(asiakasId);
	}
	
	//asiakkaan tietojen muokkaus
	@PutMapping("api/asiakkaat/{asiakasId}")
	Asiakas editAsiakas(@RequestBody Asiakas editedAsiakas, @PathVariable Long asiakasId) {
		log.info("Muokkaa asiakastietoja: " + editedAsiakas);
		editedAsiakas.setAsiakasId(asiakasId);
		return asiakasRepo.save(editedAsiakas);
	}
	
	//uuden asiakkaan luonti
	@PostMapping("api/asiakkaat")
	Asiakas newAsiakas(@RequestBody Asiakas newAsiakas) {
		log.info("Luodaan uusi asiakas: " + newAsiakas);
		return asiakasRepo.save(newAsiakas);
	}
	
	//asiakaan poisto
	@DeleteMapping("api/asiakkaat/{asiakasId}")
	Iterable<Asiakas> deleteAsiakas(@PathVariable Long asiakasId){
		log.info("Poistetaan asiakas, id: " + asiakasId);
		asiakasRepo.deleteById(asiakasId);
		return asiakasRepo.findAll();
	}
}
