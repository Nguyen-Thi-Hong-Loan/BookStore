package com.example.bookstoreproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookstore")
public class BlogController {

    @GetMapping("blog")
    public String blog() {
        return "blog";
    }


    @GetMapping("blog-details")
    public String blogDetails() {
        return "blogDetails";
    }
}
