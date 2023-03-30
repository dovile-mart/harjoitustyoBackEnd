package com.example.hoteldatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hoteldatabase.domain.HuonevarausRepository;

@Controller
public class HuonevarausController {

		@Autowired
		HuonevarausRepository huonevarausRepo;
		
		@GetMapping("/huonevaraukset")			//http://localhost:8080/huoneet
		public String listHuonevaraukset(Model model) {
			model.addAttribute("huonevaraukset", huonevarausRepo.findAll());
			return "huonevaraukset";
		}

}

