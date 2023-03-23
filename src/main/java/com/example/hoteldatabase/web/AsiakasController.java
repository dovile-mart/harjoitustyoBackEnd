package com.example.hoteldatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hoteldatabase.domain.Asiakas;
import com.example.hoteldatabase.domain.AsiakasRepository;

@Controller
public class AsiakasController {

	@Autowired
	AsiakasRepository asiakasRepo;
	
	@GetMapping("/asiakkaat")
	public String listAsiakkaat(Model model) {
		model.addAttribute("asiakas", new Asiakas());
		return "asiakkaat";
	}
}
