package com.example.bookstoreproject.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.entity.ImageEntity;
import com.example.bookstoreproject.globalData.DataCart;
import com.example.bookstoreproject.globalData.GlobalDataCart;
import com.example.bookstoreproject.services.BookService;
import com.example.bookstoreproject.services.CookieService;

@Controller
@RequestMapping("/bookstore")
public class ListBookController {

	@Autowired
	private BookService bookservice;
	
	 @Autowired
	    CookieService cookieService;

	@GetMapping("shopList")
	public String loadBook(ModelMap model) {
		
		
		List<BookEntity> listbook= (List<BookEntity>) bookservice.findAll();
		
		model.addAttribute("DatacartCount", GlobalDataCart.datacart.stream().mapToInt(DataCart::getCount).sum());
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
	        model.addAttribute("DatacartCount", GlobalDataCart.datacart.stream().mapToInt(DataCart::getCount).sum());
	        return "productDetails";
	    }
	 
	 @ResponseBody
	    @RequestMapping("shopList/likebook/{id}")
	    public boolean listBookInCart(ModelMap model, @PathVariable("id") Long id) {

	        Cookie listCart = cookieService.read("listcart");
	        String value = id.toString();
	        if (listCart != null) {
	            value = listCart.getValue();
	            if (!value.contains(id.toString())) {
	                value += "," + id.toString();
	            } else {
	                return false;
	            }
	        }
	        cookieService.create("listcart", value, 30);
	        return true;
	    }
}
