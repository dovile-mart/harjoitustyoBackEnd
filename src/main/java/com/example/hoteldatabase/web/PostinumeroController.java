package com.example.hoteldatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hoteldatabase.domain.PostinumeroRepository;

@Controller
public class PostinumeroController {

		@Autowired
		PostinumeroRepository postinumeroRepo;
		
		@GetMapping("/postinumerot")			//http://localhost:8080/postinumerot
		public String listPostinumerot(Model model) {
			model.addAttribute("postinumerot", postinumeroRepo.findAll());
			return "postinumerot";
		}

}
