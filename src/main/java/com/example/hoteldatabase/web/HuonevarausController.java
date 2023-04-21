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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.hoteldatabase.domain.HuoneRepository;
import com.example.hoteldatabase.domain.Huonevaraus;
import com.example.hoteldatabase.domain.HuonevarausRepository;
import com.example.hoteldatabase.domain.VarausRepository;

@Controller
public class HuonevarausController {

	private static final Logger log = LoggerFactory.getLogger(HuonevarausController.class);
	
	
		@Autowired
		HuonevarausRepository huonevarausRepo;
		@Autowired
		HuoneRepository huoneRepo;
		@Autowired
		VarausRepository varausRepo;
		
		//huonevarausten listan haku
		@GetMapping("/huonevaraukset")			//http://localhost:8080/huoneet
		public String listHuonevaraukset(Model model) {
			model.addAttribute("huonevaraukset", huonevarausRepo.findAll());
			model.addAttribute("varaukset", varausRepo.findAll());
			model.addAttribute("huoneet", huoneRepo.findAll());
			return "huonevaraukset";
		}
		
		//huonevarauksen luonti
		@RequestMapping("/addhuonevaraus")
		public String addHuonevaraus(Model model) {
			log.info("Luo uusi huonevaraus ");
			model.addAttribute("huonevaraus", new Huonevaraus());
			model.addAttribute("huoneet", huoneRepo.findAll());
			model.addAttribute("varaukset", varausRepo.findAll());
			
			return "addhuonevaraus";
		}
		
		//huonevarauksen muokkaus
		@GetMapping("/editHuonevaraus/{id}")
		public String editHuonevaraus(@PathVariable("id") Long huonevarausId, Model model) {
			log.info("Muokkaa huonevaraus: " + huonevarausId);
			model.addAttribute("editHuonevaraus", huonevarausRepo.findByHuonevarausId(huonevarausId));
			model.addAttribute("huoneet", huoneRepo.findAll());
			model.addAttribute("varaukset", varausRepo.findAll());
			return "edithuonevaraus";
		}
		
		//huonevarauksen tallennus
		@PostMapping("/saveHuonevaraus")
		public String saveHuonevaraus(Huonevaraus huonevaraus, BindingResult bindingResult) {
			log.info("HuonevarausController: validoinnin tarkistus, huonevaraus: " + huonevaraus);
			if(bindingResult.hasErrors()) {
				log.info("Validointivirhe");
				return "addhuonevaraus";
			}
			huonevarausRepo.save(huonevaraus);
			return "redirect:huonevaraukset";
		}
		
		//huonevarauksen poisto
		@PreAuthorize("hasAuthority('ADMIN')")
		@GetMapping("deleteHuonevaraus/{id}")
		public String deleteHuonevaraus(@PathVariable("id") Long huonevarausId, Model model) {
			log.info("Poista huonevaraus: " + huonevarausId);
			huonevarausRepo.deleteById(huonevarausId);
			return "redirect:/huonevaraukset";
		}
		

}

