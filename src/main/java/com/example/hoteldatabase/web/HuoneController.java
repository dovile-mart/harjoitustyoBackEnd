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

import com.example.hoteldatabase.domain.Huone;
import com.example.hoteldatabase.domain.HuoneRepository;

@Controller
public class HuoneController {

	private static final Logger log = LoggerFactory.getLogger(HuoneController.class);
	
		@Autowired
		HuoneRepository huoneRepo;
		
		//huonelistaus
		@GetMapping("/huoneet")			//http://localhost:8080/huoneet
		public String listHuoneet(Model model) {
			model.addAttribute("huoneet", huoneRepo.findAll()); //huoneet - olio jonka thymeleaf käyttää
			return "huoneet";		//huoneet.html kutsu
		}
		
		//huoneen luonti
		@GetMapping("/addHuone")
		public String addHuone(Model model) {
			log.info("Luo uusi huone");
			model.addAttribute("uusiHuone", new Huone());
			return "addhuone";
		}
		
		//huoneen tietojen muokkaus
		@GetMapping("/editHuone/{id}")
		public String editHuone(@PathVariable("id") String huoneNro, Model model ) {
			log.info("Muokkaa huoneen " + huoneNro + " tiedot");
			model.addAttribute("editHuone", huoneRepo.findByHuoneNro(huoneNro));
			return "edithuone";
		}
	
		
		//huoneen tallennus+validointi
		@PostMapping("/saveHuone")
		public String saveHuone( Huone huone, BindingResult bindingResult) { //@Valid
			log.info("HuoneController: validoinnin tarkistus, huone: " + huone);
			if(bindingResult.hasErrors()) {
				log.info("Validointivirhe");
				return "addhuone";
			}
			huoneRepo.save(huone);
			return "redirect:huoneet";
		}
		
		//huoneen poisto
		@GetMapping("deleteHuone/{id}")
		public String deleteHuone(@PathVariable("id") String huoneNro, Model model) {
			log.info("Poista huone nro: " + huoneNro);
			huoneRepo.deleteById(huoneNro);
			return "redirect:/huoneet";
		}
}
