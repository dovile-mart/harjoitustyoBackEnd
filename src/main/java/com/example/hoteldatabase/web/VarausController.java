package com.example.hoteldatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hoteldatabase.domain.VarausRepository;

@Controller
public class VarausController {
		@Autowired
		VarausRepository varausRepo;
		
		@GetMapping("/varaukset")			//http://localhost:8080/varaukset
		public String listVarauksett(Model model) {
			model.addAttribute("varaukset", varausRepo.findAll());
			return "varaukset";
		}
}