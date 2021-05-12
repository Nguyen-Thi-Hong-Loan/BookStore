package com.example.bookstoreproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.entity.ImageEntity;
import com.example.bookstoreproject.services.BookService;

@Controller
@RequestMapping("/bookstore")
public class ListBookController {

	@Autowired
	private BookService bookservice;
	
	@GetMapping("shopList")
	public String loadBook(ModelMap model) {
		
		
		List<BookEntity> listbook= (List<BookEntity>) bookservice.findAll();
		

		model.addAttribute("listbooks", listbook);
		return "shopList";
	}
	
	 @RequestMapping("detailBook/{id}")
	    public String detailBook(ModelMap model, @PathVariable(name = "id") Long id) {
	        Optional<BookEntity> optionBook = bookservice.findById(id);
	        if (optionBook.isPresent()) {
	            String author = optionBook.get().getAuthor();
	            List<BookEntity> listSuggestions = (List<BookEntity>) bookservice.findByAuthor(author);

	            List<ImageEntity> images = optionBook.get().getImage();

	            model.addAttribute("listsuggestions", listSuggestions);
	            model.addAttribute("image", images);
	            model.addAttribute("book", optionBook.get());

	        } else {
	            return loadBook(model);
	        }

	        return "productDetails";
	    }
}
