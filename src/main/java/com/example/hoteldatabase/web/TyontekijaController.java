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

import com.example.hoteldatabase.domain.PostinumeroRepository;
import com.example.hoteldatabase.domain.Tyontekija;
import com.example.hoteldatabase.domain.TyontekijaRepository;

import jakarta.validation.Valid;

@Controller
public class TyontekijaController {

	private static final Logger log = LoggerFactory.getLogger(TyontekijaController.class);
	
	@Autowired
	private TyontekijaRepository tyontekijaRepo;
	@Autowired
	private PostinumeroRepository postinumeroRepo;
	
	//työntekijöiden listaus
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/tyontekijat")
	public String listTyontekijat(Model model) {
		model.addAttribute("tyontekijat", tyontekijaRepo.findAll());
		return "tyontekijat";
	}
	
	//työntekijän luonti
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addTyontekija")
	public String addTyontekija(Model model) {
		log.info("Luo uusi tyontekija.");
		model.addAttribute("tyontekija", new Tyontekija());
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		return "addtyontekija";
	}
	
	
	//työntekijän tietojen muokkaus
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editTyontekija/{id}")
	public String editTyontekija(@PathVariable("id") Long tyontekijaId, Model model ) {
		log.info("Muokkaa tyontekijatiedot." + tyontekijaId);
		model.addAttribute("editTyontekija", tyontekijaRepo.findById(tyontekijaId));
		model.addAttribute("postinumerot", postinumeroRepo.findAll());
		return "edittyontekija";
	}
	
	
	//työntekijän tietojen tallennus ja  validoinnin tarkistus
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/saveTyontekija")
	public String saveTyontekija(@Valid Tyontekija tyontekija, BindingResult bindingResult, Model model) {
		log.info("Controller: check validation of tyontekija: " + tyontekija);
		if(bindingResult.hasErrors()) {
			log.info("Validointivirhe");
			model.addAttribute("postinumerot", postinumeroRepo.findAll());
			return "addtyontekija";
		}
		tyontekijaRepo.save(tyontekija);
		return "redirect:/tyontekijat";
	}
	
	
	//työntekijän poisto
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("deleteTyontekija/{id}")
	public String deleteTyontekija(@PathVariable("id") Long id, Model model) {
		log.info("Poista tyontekija " + id);
		tyontekijaRepo.deleteById(id);
		return "redirect:/tyontekijat";
	}
}
