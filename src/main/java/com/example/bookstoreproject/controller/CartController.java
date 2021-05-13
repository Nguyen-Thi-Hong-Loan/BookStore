package com.example.bookstoreproject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.globalData.DataCart;
import com.example.bookstoreproject.globalData.GlobalData;
import com.example.bookstoreproject.services.BookService;
import com.example.bookstoreproject.services.CookieService;

@Controller
@RequestMapping("/bookstore")
public class CartController {

	
	@Autowired
	private BookService bookService;

	@Autowired
	private CookieService cookieService;

	@RequestMapping("cart")
	public String listPost(ModelMap model, Principal principal) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("cartTotal", GlobalData.cart.stream().mapToDouble(BookEntity::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		
		model.addAttribute("DatacartCount", GlobalData.datacart.stream().mapToInt(DataCart:: getCount).sum());
		model.addAttribute("DatacartTotal", GlobalData.datacart.stream().mapToDouble(DataCart:: totalPrice).sum());
		model.addAttribute("Datacart", GlobalData.datacart);
		return "cart";
	}


	@RequestMapping("shopList/addcart/{id}")
	public String listBookInCart(ModelMap model, @PathVariable("id") Long id) {
		
		
		DataCart data = new DataCart(bookService.findById(id).get(), 1);
		if(GlobalData.datacart==null) {
			GlobalData.datacart.add(data);
			
		}else {
			for(int i=0; i<GlobalData.datacart.size();i++) {
				if(GlobalData.datacart.get(i).getBook().getId() == id) {
					GlobalData.datacart.get(i).setCount(GlobalData.datacart.get(i).getCount()+1 );
				}else {
					GlobalData.datacart.add(data);
				}
			}
		}
		
		GlobalData.cart.add(bookService.findById(id).get());
		
		
		return "redirect:/bookstore/shopList";

	}

	@RequestMapping("shopList/removecart/{index}")
	public String removelistBookInCart(ModelMap model, @PathVariable("index") int index) {
		
		GlobalData.cart.remove(index);
		
		return "redirect:/bookstore/cart";

	}
	@RequestMapping("shopList/clearcart")
	public String clearlistBookInCart(ModelMap model) {
		
		GlobalData.cart.clear();;
		
		return "redirect:/bookstore/cart";

	}

}
