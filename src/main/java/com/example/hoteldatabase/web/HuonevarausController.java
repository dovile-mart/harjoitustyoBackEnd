package com.example.hoteldatabase.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
			return "huonevaraukset";
		}
		
		//huonevarauksen luonti
		@RequestMapping("/addHuonevaraus")
		public String addHuonevaraus(Model model) {
			log.info("Luo uusi huonevaraus ");
			model.addAttribute("uusiHuonevaraus", new Huonevaraus());
			model.addAttribute("huoneet", huoneRepo.findAll());
			return "addhuonevaraus";
		}

}

