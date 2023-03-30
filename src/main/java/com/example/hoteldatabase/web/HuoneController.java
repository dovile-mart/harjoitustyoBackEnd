package com.example.hoteldatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hoteldatabase.domain.HuoneRepository;

@Controller
public class HuoneController {

		@Autowired
		HuoneRepository huoneRepo;
		
		@GetMapping("/huoneet")			//http://localhost:8080/huoneet
		public String listHuoneet(Model model) {
			model.addAttribute("huoneet", huoneRepo.findAll());
			return "huoneet";
		}

}
