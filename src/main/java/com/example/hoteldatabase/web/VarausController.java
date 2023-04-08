package com.example.hoteldatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hoteldatabase.domain.AsiakasRepository;
import com.example.hoteldatabase.domain.HuonevarausRepository;
import com.example.hoteldatabase.domain.TyontekijaRepository;
import com.example.hoteldatabase.domain.VarausRepository;

@Controller
public class VarausController {
		@Autowired
		VarausRepository varausRepo;
		@Autowired
		HuonevarausRepository huonevarausRepo;
		@Autowired
		AsiakasRepository asiakasRepo;
		@Autowired
		TyontekijaRepository tyontekijaRepo;
		
		@GetMapping("/varaukset")			//http://localhost:8080/varaukset
		public String listVarauksett(Model model) {
			model.addAttribute("varaukset", varausRepo.findAll());
			model.addAttribute("huonevaraukset", huonevarausRepo.findAll());
			model.addAttribute("asiakkaat", asiakasRepo.findAll());
			model.addAttribute("tyontekijat", tyontekijaRepo.findAll());
			return "varaukset";
		}
}