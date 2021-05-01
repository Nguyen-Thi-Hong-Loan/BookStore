package com.exam.bookstoreproject.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/bookstore")
public class MasterController {
	
	
//	@Autowired
//	private PostService postservice;

	@GetMapping("home")
	public String loadHome(ModelMap model) {

		return "home";
	}

	@GetMapping("error404")
	public String showError404() {
		return "404";
	}
}
