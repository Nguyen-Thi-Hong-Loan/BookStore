package com.example.bookstoreproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstoreproject.entity.BlogEntity;
import com.example.bookstoreproject.services.BlogService;

@Controller
@RequestMapping("/bookstore")
public class BlogController {
	@Autowired
	private BlogService blogservice;

    @GetMapping("blog")
    public String blog(ModelMap model) {
    	List<BlogEntity> listblog= (List<BlogEntity>) blogservice.findAll();
    	model.addAttribute("listblogs", listblog);
        return "blog";
    }


    @GetMapping("blog-details")
    public String blogDetails() {
        return "blogDetails";
    }
}
