package com.example.hoteldatabase.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.hoteldatabase.domain.Asiakas;
import com.example.hoteldatabase.domain.AsiakasRepository;

import jakarta.validation.Valid;


@RestController
public class AsiakasRestController {
	private static final Logger log = LoggerFactory.getLogger(AsiakasRestController.class);

	
	@Autowired
	AsiakasRepository asiakasRepo;
	
	
	//hakee kaikki asiakkaat
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("api/asiakkaat")
	public Iterable<Asiakas> getAsiakas(){
		log.info("Haetaan kaikki asiakkaat:");
		try {
			return asiakasRepo.findAll();			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested resource does not exist");
		}
	}
	
	//hakee yhden asiakkaan tiedot
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("api/asiakkaat/{asiakasId}")
	@ResponseBody 
//	Optional<Asiakas> getAsiakas(@PathVariable Long asiakasId) {	//palauttaa null, jos asiakasta ei ole
	public Asiakas findAsiakas(@PathVariable("asiakasId") Long asiakasId) {
		log.info("Hae asiakas id:llä: " + asiakasId);
		try {
			return asiakasRepo.findById(asiakasId).get();			
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asiakasta id:llä " + asiakasId + " ei löydy");
		}
	}
	
	//asiakkaan tietojen muokkaus
	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping("api/asiakkaat/{asiakasId}")
	@ResponseStatus(HttpStatus.CREATED)
	Asiakas editAsiakas(@RequestBody Asiakas editedAsiakas, @PathVariable Long asiakasId) {
		log.info("Muokkaa asiakastietoja: " + editedAsiakas.toString());
		if (asiakasRepo.findByAsiakasId(asiakasId).size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asiakasta id:llä " + asiakasId + " ei löydy");
		}
		if (editedAsiakas.getAsiakasId() != asiakasId) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "URLissa oleva id: " + asiakasId + " ja lomakkeessa oleva id:" + editedAsiakas.getAsiakasId() + " eivät täsmänneet");
		}
		if (asiakasRepo.findByEtunimiAndSukunimi(editedAsiakas.getEtunimi(), editedAsiakas.getSukunimi()).size()>0) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Asiakas samalla nimellä on jo tietokannassa");
		}

		try {editedAsiakas.setAsiakasId(asiakasId);
			return asiakasRepo.save(editedAsiakas);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Not acceptable");
		}
		
		
	}
	
	//uuden asiakkaan luonti
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("api/asiakkaat")
	@ResponseStatus(HttpStatus.CREATED)
	public Asiakas newAsiakas(@Valid @RequestBody Asiakas newAsiakas) {
		log.info("Luodaan uusi asiakas: ");
		List<Asiakas> asiakkaanNimi = asiakasRepo.findByEtunimiAndSukunimi(newAsiakas.getEtunimi(),newAsiakas.getSukunimi());
		log.info("Yritetään tallentaa uusi asiakas: " + newAsiakas);
		
		if (asiakkaanNimi.size() > 0) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Samanniminen asiakas on jo olemassa");
		}
		try {
			log.info("Tallennetaan uusi asiakas: " + newAsiakas);
			return asiakasRepo.save(newAsiakas);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Not acceptable");
		}
	}
	
	//asiakaan poisto
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("api/asiakkaat/{asiakasId}")
	void deleteAsiakas(@Valid @PathVariable Long asiakasId){
		log.info("Poistetaan asiakas id:llä " + asiakasRepo.findById(asiakasId));//.toString());
		if (asiakasRepo.findByAsiakasId(asiakasId).size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Asiakasta id:llä " + asiakasId + " ei löydy");
		}
		try {
			asiakasRepo.deleteById(asiakasId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Ei voida poistaa, asiakkaalla saattaa olla yhteyksiä muihin tauluihin");
		}
	}
}
