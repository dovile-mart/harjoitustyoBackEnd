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

import com.example.hoteldatabase.domain.AsiakasRepository;
import com.example.hoteldatabase.domain.Huonevaraus;
import com.example.hoteldatabase.domain.HuonevarausRepository;
import com.example.hoteldatabase.domain.TyontekijaRepository;
import com.example.hoteldatabase.domain.Varaus;
import com.example.hoteldatabase.domain.VarausRepository;

@Controller
public class VarausController {
	
	private static final Logger log = LoggerFactory.getLogger(VarausController.class);
	
		@Autowired
		VarausRepository varausRepo;
		@Autowired
		HuonevarausRepository huonevarausRepo;
		@Autowired
		AsiakasRepository asiakasRepo;
		@Autowired
		TyontekijaRepository tyontekijaRepo;
		
		//varausten listaus
		@GetMapping("/varaukset")			//http://localhost:8080/varaukset
		public String listVaraukset(Model model) {
			model.addAttribute("varaukset", varausRepo.findAll());
//			model.addAttribute("huonevaraukset", huonevarausRepo.findAll());
//			model.addAttribute("asiakkaat", asiakasRepo.findAll());
//			model.addAttribute("tyontekijat", tyontekijaRepo.findAll());
			return "varaukset";
		}
			
		
		//varauksen luonti
		@RequestMapping("/addVaraus")
		public String addVaraus(Model model) {
			log.info("Luo uusi varaus ");
			model.addAttribute("varaus", new Varaus());
			model.addAttribute("huonevaraukset", huonevarausRepo.findAll());
			model.addAttribute("asiakkaat", asiakasRepo.findAll());
			model.addAttribute("tyontekijat", tyontekijaRepo.findAll());
			return "addvaraus";
		}
		
		//varauksen muokkaus
		@GetMapping("/editVaraus/{id}")
		public String editVaraus(@PathVariable("id") Long varausId, Model model) {
			log.info("Muokkaa varaus: " + varausId);
			model.addAttribute("editVaraus", varausRepo.findByVarausId(varausId));
			model.addAttribute("huonevaraukset", huonevarausRepo.findAll());
			model.addAttribute("asiakkaat", asiakasRepo.findAll());
			model.addAttribute("tyontekijat", tyontekijaRepo.findAll());
			return "editvaraus";
		}
		
		//varauksen tallennus
		@PostMapping("/saveVaraus")
		public String saveVaraus(Varaus varaus, BindingResult bindingResult) {
			log.info("VarausController: validoinnin tarkistus, varaus: " + varaus);
			if(bindingResult.hasErrors()) {
				log.info("Validointivirhe");
				return "addvaraus";
			}
			varausRepo.save(varaus);
			return "redirect:varaukset";
		}
		
		//varauksen poisto
		@PreAuthorize("hasAuthority('ADMIN')")
		@GetMapping("deleteVaraus/{id}")
		public String deleteVvaraus(@PathVariable("id") Long varausId, Model model) {
			log.info("Poista varaus: " + varausId);
			varausRepo.deleteById(varausId);
			return "redirect:/varaukset";
		}
		
		
}