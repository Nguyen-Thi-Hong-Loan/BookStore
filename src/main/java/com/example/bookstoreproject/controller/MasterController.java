package com.example.bookstoreproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstoreproject.entity.BlogEntity;
import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.globalData.GlobalData;
import com.example.bookstoreproject.services.BlogService;
import com.example.bookstoreproject.services.BookService;

@Controller
@RequestMapping("/bookstore")
public class MasterController {

	String publisher = "NXB Trẻ";
	
	@Autowired
	private BookService bookservice;
	@Autowired
	private BlogService blogservice;

	@GetMapping("home")
	public String loadHome(ModelMap model) {
		List<BookEntity> listpublisher= (List<BookEntity>) bookservice.findByPublisher(publisher);
		
		List<BlogEntity> listblog= (List<BlogEntity>) blogservice.findAll();
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("listpublishers", listpublisher);
		model.addAttribute("listblogs", listblog);
		return "home";
	}

	@GetMapping("error404")
	public String showError404() {
		return "page404";
	}
}
