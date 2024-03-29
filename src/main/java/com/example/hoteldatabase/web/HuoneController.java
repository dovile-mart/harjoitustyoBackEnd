package com.example.hoteldatabase.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hoteldatabase.domain.Huone;
import com.example.hoteldatabase.domain.HuoneRepository;

import jakarta.validation.Valid;

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
		@PreAuthorize("hasAuthority('ADMIN')")
		@GetMapping("/addHuone")
		public String addHuone(Model model) {
			log.info("Luo uusi huone");
			model.addAttribute("huone", new Huone());
			return "addhuone";
		}
		
		//huoneen tietojen muokkaus
		@PreAuthorize("hasAuthority('ADMIN')")
		@GetMapping("/editHuone/{id}")
		public String editHuone(@PathVariable("id") Long id, Model model ) {
			log.info("Muokkaa huoneen (id: " + id + ") tiedot");
			model.addAttribute("editHuone", huoneRepo.findById(id));
			model.addAttribute("id", id);
			return "edithuone";
		}
	
		
		//huoneen tallennus+validointi
		@PreAuthorize("hasAuthority('ADMIN')")
		@PostMapping("/saveHuone")
		public String saveHuone(@Valid Huone huone, BindingResult bindingResult, Model model) {
			log.info("HuoneController: validoinnin tarkistus, huone: " + huone);
			if(bindingResult.hasErrors()) {
				log.info("Validointivirhe");
				return "/addhuone";
			}
			huoneRepo.save(huone);
			return "redirect:/huoneet";
		}
		
		//huoneen poisto
		@PreAuthorize("hasAuthority('ADMIN')")
		@GetMapping("deleteHuone/{id}")
		public String deleteHuone(@PathVariable("id") Long id) {//String huoneNro) {
			log.info("Poista huone (id: " + id + ")");
			huoneRepo.deleteById(id);
			return "redirect:/huoneet";
		}
}
