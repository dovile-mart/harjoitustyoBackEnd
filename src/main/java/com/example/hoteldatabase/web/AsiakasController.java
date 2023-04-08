package com.example.hoteldatabase.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hoteldatabase.domain.Asiakas;
import com.example.hoteldatabase.domain.AsiakasRepository;
import com.example.hoteldatabase.domain.PostinumeroRepository;

//import jakarta.validation.Valid;

@Controller
public class AsiakasController {

	private static final Logger log = LoggerFactory.getLogger(AsiakasController.class);
	
	@Autowired
	private AsiakasRepository asiakasRepo;
	@Autowired
	private PostinumeroRepository postinumeroRepo;

	//pääsivu
	@GetMapping(value= {"/", "index"})
	public String showMainPage() {
		log.info("Avaa etusivu");
		return "index";
	}
	
	//kaikkien asiakkaiden listaus
	@GetMapping("/asiakkaat")			//http://localhost:8080/asiakkaat
	public String listAsiakkaat(Model model) {
		log.info("Hae kaikki asiakkaat tietokannasta.");
		model.addAttribute("asiakkaat", asiakasRepo.findAll());
		return "asiakkaat";
	}
	
	//asiakkaan luonti
	@GetMapping("/addAsiakas")
	public String addAsiakas(Model model) {
		log.info("Luo uusi asiakas.");
		model.addAttribute("uusiAsiakas", new Asiakas());
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		return "addasiakas";
	}
	
	//asiakkaan muokkaus
	@GetMapping("/editAsiakas/{id}")
	public String editAsiakas(@PathVariable("id") Long asiakasId, Model model ) {
		log.info("Muokkaa asiakastiedot." + asiakasId);
		model.addAttribute("editAsiakas", asiakasRepo.findById(asiakasId));
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		return "editasiakas";
	}
	
	//asiakkaan lomaketietojen tallennus + validoinnin tarkistus
	@PostMapping("/saveAsiakas")
	public String saveAsiakas( Asiakas asiakas, BindingResult bindingResult) { //@Valid
		log.info("AsiakasController: validoinnin tarkistus, asiakas: " + asiakas);
		if(bindingResult.hasErrors()) {
			log.info("Validointivirhe");
			return "addasiakas";
		}
		asiakasRepo.save(asiakas); //jos kaikki hyvin, tallennetaan asiakas tietokantaan
		return "redirect:asiakkaat";
	}
	
	//asiakkaan poisto
	@GetMapping("deleteAsiakas/{id}")
	public String deleteAsiakas(@PathVariable("id") Long id, Model model) {
		log.info("Poista asiakas: " + id);
		asiakasRepo.deleteById(id);
		return "redirect:/asiakkaat";
	}
}
