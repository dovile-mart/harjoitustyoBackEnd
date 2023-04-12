package com.example.hoteldatabase.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hoteldatabase.domain.Asiakas;
import com.example.hoteldatabase.domain.AsiakasRepository;
import com.example.hoteldatabase.domain.Postinumero;
import com.example.hoteldatabase.domain.PostinumeroRepository;
import com.example.hoteldatabase.domain.VarausRepository;

import jakarta.validation.Valid;

//import jakarta.validation.Valid;

@Controller
public class AsiakasController {

	private static final Logger log = LoggerFactory.getLogger(AsiakasController.class);
	
	@Autowired
	private AsiakasRepository asiakasRepo;
	@Autowired
	private PostinumeroRepository postinumeroRepo;
	@Autowired
	private VarausRepository varausRepo;

	//pääsivu
	@GetMapping(value= {"/", "index"})
	public String showMainPage() {
		log.info("Avaa etusivu");
		return "index";
	}
	
	//kaikkien asiakkaiden listaus
	@GetMapping("/asiakas/asiakkaat")			//http://localhost:8080/asiakkaat
	public String listAsiakkaat(Model model) {
		log.info("Hae kaikki asiakkaat tietokannasta.");
		model.addAttribute("asiakkaat", asiakasRepo.findAll());
		model.addAttribute("varaukset", varausRepo.findAll());
		return "asiakas/asiakkaat";
	}
	/*//https://stackabuse.com/spring-boot-thymeleaf-form-data-validation-with-bean-validator/
	@GetMapping("/asiakas/addAsiakas")
	public String showAddAsiakasForm(Model model) {
		model.addAttribute("asiakas", new Asiakas()); //uusiAsiakas
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		return "asiakas/addasiakas";
	}
	
	@PostMapping("/asiakas/addAsiakas")
	public String addAsiakas(@Valid Asiakas asiakas, BindingResult result, Model model) {
		log.info("Luo uusi asiakas.");
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		if (result.hasErrors()) {
			//model.addAttribute("postinumerot", postinumeroRepo.findAll());
			return "asiakas/addasiakas";
		}
	//	model.addAttribute("postinumerot", postinumeroRepo.findAll());
		asiakasRepo.save(asiakas);
		return "redirect:asiakas/asiakkaat";
//		return "asiakas/addasiakas";//newAsiakas
	}
*/	
	//asiakkaan luonti
	@GetMapping("/asiakas/addAsiakas")
	public String addAsiakas(Model model) {
		log.info("Luo uusi asiakas.");
		model.addAttribute("asiakas", new Asiakas()); //uusiAsiakas
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		return "asiakas/addasiakas";//newAsiakas
	}
	
	//asiakkaan muokkaus
	@GetMapping("/editAsiakas/{id}")
	public String editAsiakas(@PathVariable("id") Long asiakasId, Model model ) {
		log.info("Muokkaa asiakastiedot." + asiakasId);
		model.addAttribute("editAsiakas", asiakasRepo.findById(asiakasId));
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		return "asiakas/editasiakas";
	}
	
	//asiakkaan lomaketietojen tallennus + validoinnin tarkistus
	@PostMapping("/saveAsiakas")
	public String saveAsiakas(@Valid @ModelAttribute("asiakas") Asiakas asiakas, BindingResult bindingResult, Model model) { //uusiAsiakas
		log.info("AsiakasController: validoinnin tarkistus, asiakas: " + asiakas);
		if(bindingResult.hasErrors()) {
			log.info("Validointivirhe, postinumerot ja asiakkaat: " + postinumeroRepo.findAll() + asiakasRepo.findAll() );
	//		model.addAttribute("asiakkaat", asiakasRepo.findAllById(asiakasId).get(0)));
			model.addAttribute("postinumerot", postinumeroRepo.findAll());
			return "asiakas/addasiakas"; //newAsiakas
		}
		asiakasRepo.save(asiakas); //jos kaikki hyvin, tallennetaan asiakas tietokantaan
		return "redirect:asiakas/asiakkaat";
	}
	
	//asiakkaan poisto
	@GetMapping("deleteAsiakas/{id}")
	public String deleteAsiakas(@PathVariable("id") Long id, Model model) {
		log.info("Poista asiakas: " + id);
		asiakasRepo.deleteById(id);
		return "redirect:asiakas/asiakkaat";
	}
	
	//asiakkaan varaukset
	@GetMapping("/asiakasvaraukset/{id}")
	public String asiakasvaraukset(@PathVariable("id") Long asiakasId, Model model ) {
		log.info("Hae asiakkaan (id: " + asiakasId + ") varaukset:");
		model.addAttribute("asiakasvaraukset", asiakasRepo.findById(asiakasId));
		model.addAttribute("varaukset", varausRepo.findAll());
		return "asiakasvaraukset";
	}
}
