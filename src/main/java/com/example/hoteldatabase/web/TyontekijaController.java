package com.example.hoteldatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hoteldatabase.domain.Tyontekija;
import com.example.hoteldatabase.domain.TyontekijaRepository;

@Controller
public class TyontekijaController {

	@Autowired
	TyontekijaRepository tyontekijaRepo;
	
	@GetMapping("/tyontekijat")
	public String listTyontekijat(Model model) {
		model.addAttribute("tyontekijat", tyontekijaRepo.findAll());
		return "tyontekijat";
	}
}
