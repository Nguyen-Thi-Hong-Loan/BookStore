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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstoreproject.entity.BookEntity;
import com.example.bookstoreproject.globalData.DataCart;
import com.example.bookstoreproject.globalData.GlobalDataCart;
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


		model.addAttribute("DatacartCount", GlobalDataCart.datacart.stream().mapToInt(DataCart::getCount).sum());
		model.addAttribute("DatacartTotal", GlobalDataCart.datacart.stream().mapToDouble(DataCart::totalPrice).sum());
		model.addAttribute("Datacart", GlobalDataCart.datacart);
		return "cart";
	}
	@ResponseBody
	@RequestMapping("shopList/addcart/{id}")
	public Object[] listBookInCart(ModelMap model, @PathVariable("id") Long id) {

		DataCart data = new DataCart(bookService.findById(id).get(), 1);
		int step = 0;
		if (GlobalDataCart.datacart.size() == 0) {
			GlobalDataCart.datacart.add(data);

		} else {

			for (int i = 0; i < GlobalDataCart.datacart.size(); i++) {
				if (GlobalDataCart.datacart.get(i).getBook().getId() == id) {
					GlobalDataCart.datacart.get(i).setCount(GlobalDataCart.datacart.get(i).getCount() + 1);
				}
			}

			for (int i = 0; i < GlobalDataCart.datacart.size(); i++) {
				if (GlobalDataCart.datacart.get(i).getBook().getId() != id) {
					step += 1;
				}
			}
			if (step == GlobalDataCart.datacart.size()) {
				GlobalDataCart.datacart.add(data);

			}
		}
		
		Object[] object= {GlobalDataCart.datacart.stream().mapToInt(DataCart::getCount).sum(),GlobalDataCart.datacart.stream().mapToDouble(DataCart::totalPrice).sum()};
				

		return object;

	}
	
	// tang so luong sach trong gio
	@ResponseBody
	@RequestMapping("shopList/cart/updatecart/{id}")
	public Object[] updateBookInCart(ModelMap model, @PathVariable("id") Long id) {

		DataCart data = new DataCart(bookService.findById(id).get(), 1);
		int step = 0;
		int count=0;
		if (GlobalDataCart.datacart.size() == 0) {
			GlobalDataCart.datacart.add(data);

		} else {

			for (int i = 0; i < GlobalDataCart.datacart.size(); i++) {
				if (GlobalDataCart.datacart.get(i).getBook().getId() == id) {
					GlobalDataCart.datacart.get(i).setCount(GlobalDataCart.datacart.get(i).getCount() + 1);
					count= GlobalDataCart.datacart.get(i).getCount();
				}
			}

			for (int i = 0; i < GlobalDataCart.datacart.size(); i++) {
				if (GlobalDataCart.datacart.get(i).getBook().getId() != id) {
					step += 1;
				}
			}
			if (step == GlobalDataCart.datacart.size()) {
				GlobalDataCart.datacart.add(data);

			}
		}

		Object[] object= {GlobalDataCart.datacart.stream().mapToInt(DataCart::getCount).sum(),GlobalDataCart.datacart.stream().mapToDouble(DataCart::totalPrice).sum(),count};

		return object;

	}
	// giam so luong sach trong gio
		@ResponseBody
		@RequestMapping("shopList/cart/downUpdatecart/{id}")
		public Object[] downUpdateBookInCart(ModelMap model, @PathVariable("id") Long id) {
				int count =0;
				for (int i = 0; i < GlobalDataCart.datacart.size(); i++) {
					if (GlobalDataCart.datacart.get(i).getBook().getId() == id && GlobalDataCart.datacart.get(i).getCount()>1 ) {
						GlobalDataCart.datacart.get(i).setCount(GlobalDataCart.datacart.get(i).getCount() - 1);
						count= GlobalDataCart.datacart.get(i).getCount();
					}
				}

				
			

				Object[] object= {GlobalDataCart.datacart.stream().mapToInt(DataCart::getCount).sum(),GlobalDataCart.datacart.stream().mapToDouble(DataCart::totalPrice).sum(),count};

			return object;

		}
	@RequestMapping("shopList/removecart/{index}")
	public String removelistBookInCart(ModelMap model, @PathVariable("index") int index) {

		GlobalDataCart.datacart.remove(index);

		return "redirect:/bookstore/cart";

	}

	@RequestMapping("shopList/clearcart")
	public String clearlistBookInCart(ModelMap model) {

		GlobalDataCart.datacart.clear();

		return "redirect:/bookstore/cart";

	}
	@RequestMapping("shopList/cart/checkout")
	public String checoutkBookInCart(ModelMap model) {

		
		model.addAttribute("DatacartCount", GlobalDataCart.datacart.stream().mapToInt(DataCart::getCount).sum());
		model.addAttribute("DatacartTotal", GlobalDataCart.datacart.stream().mapToDouble(DataCart::totalPrice).sum());
		model.addAttribute("Datacart", GlobalDataCart.datacart);
		return "checkout";

	}
}
