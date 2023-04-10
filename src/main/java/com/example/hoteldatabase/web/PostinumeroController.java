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

import com.example.hoteldatabase.domain.Postinumero;
import com.example.hoteldatabase.domain.PostinumeroRepository;

@Controller
public class PostinumeroController {

	private static final Logger log = LoggerFactory.getLogger(PostinumeroController.class);
		@Autowired
		PostinumeroRepository postinumeroRepo;
		
		@GetMapping("/postinumerot")			//http://localhost:8080/postinumerot
		public String listPostinumerot(Model model) {
			model.addAttribute("postinumerot", postinumeroRepo.findAll());
			return "postinumerot";
		}
		
		//postinumeron luonti
		@GetMapping("/addPostinumero")
		public String addPostinumero(Model model) {
			log.info("Luo uusi postinumero");
			model.addAttribute("uusiPostinumero", new Postinumero());
			return "addpostinumero";
		}
		
		//postinumeron tietojen muokkaus
		@GetMapping("/editPostinumero/{id}")
		public String editPostinumero(@PathVariable("id") String postinumero, Model model ) {
			log.info("Muokkaa postinumeron " + postinumero + " tiedot");
			model.addAttribute("editPostinumero", postinumeroRepo.findByPostinumero(postinumero));
			return "editpostinumero";
		}
	
		
		//postinumeron tallennus+validointi
		@PostMapping("/savePostinumero")
		public String savePostinumero( Postinumero postinumero, BindingResult bindingResult) { //@Valid
			log.info("PostinumeroController: validoinnin tarkistus, postinumero: " + postinumero);
			if(bindingResult.hasErrors()) {
				log.info("Validointivirhe");
				return "addpostinumero";
			}
			postinumeroRepo.save(postinumero);
			return "redirect:postinumerot";
		}
		
		//postinumeron poisto
		@GetMapping("deletePostinumero/{id}")
		public String deletePostinumero(@PathVariable("id") String postinumero, Model model) {
			log.info("Poista postinumero: " + postinumero);
			postinumeroRepo.deleteById(postinumero);
			return "redirect:/postinumerot";
		}

}
