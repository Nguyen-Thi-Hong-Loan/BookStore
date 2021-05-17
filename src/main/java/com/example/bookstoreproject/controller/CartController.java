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


		model.addAttribute("DatacartCount", GlobalData.datacart.stream().mapToInt(DataCart::getCount).sum());
		model.addAttribute("DatacartTotal", GlobalData.datacart.stream().mapToDouble(DataCart::totalPrice).sum());
		model.addAttribute("Datacart", GlobalData.datacart);
		return "cart";
	}
	@ResponseBody
	@RequestMapping("shopList/addcart/{id}")
	public Object[] listBookInCart(ModelMap model, @PathVariable("id") Long id) {

		DataCart data = new DataCart(bookService.findById(id).get(), 1);
		int step = 0;
		if (GlobalData.datacart.size() == 0) {
			GlobalData.datacart.add(data);

		} else {

			for (int i = 0; i < GlobalData.datacart.size(); i++) {
				if (GlobalData.datacart.get(i).getBook().getId() == id) {
					GlobalData.datacart.get(i).setCount(GlobalData.datacart.get(i).getCount() + 1);
				}
			}

			for (int i = 0; i < GlobalData.datacart.size(); i++) {
				if (GlobalData.datacart.get(i).getBook().getId() != id) {
					step += 1;
				}
			}
			if (step == GlobalData.datacart.size()) {
				GlobalData.datacart.add(data);

			}
		}
		
		Object[] object= {GlobalData.datacart.stream().mapToInt(DataCart::getCount).sum(),GlobalData.datacart.stream().mapToDouble(DataCart::totalPrice).sum()};
				

		return object;

	}
	
	// tang so luong sach trong gio
	@ResponseBody
	@RequestMapping("shopList/cart/updatecart/{id}")
	public Object[] updateBookInCart(ModelMap model, @PathVariable("id") Long id) {

		DataCart data = new DataCart(bookService.findById(id).get(), 1);
		int step = 0;
		int count=0;
		if (GlobalData.datacart.size() == 0) {
			GlobalData.datacart.add(data);

		} else {

			for (int i = 0; i < GlobalData.datacart.size(); i++) {
				if (GlobalData.datacart.get(i).getBook().getId() == id) {
					GlobalData.datacart.get(i).setCount(GlobalData.datacart.get(i).getCount() + 1);
					count= GlobalData.datacart.get(i).getCount();
				}
			}

			for (int i = 0; i < GlobalData.datacart.size(); i++) {
				if (GlobalData.datacart.get(i).getBook().getId() != id) {
					step += 1;
				}
			}
			if (step == GlobalData.datacart.size()) {
				GlobalData.datacart.add(data);

			}
		}

		Object[] object= {GlobalData.datacart.stream().mapToInt(DataCart::getCount).sum(),GlobalData.datacart.stream().mapToDouble(DataCart::totalPrice).sum(),count};

		return object;

	}
	// giam so luong sach trong gio
		@ResponseBody
		@RequestMapping("shopList/cart/downUpdatecart/{id}")
		public Object[] downUpdateBookInCart(ModelMap model, @PathVariable("id") Long id) {
				int count =0;
				for (int i = 0; i < GlobalData.datacart.size(); i++) {
					if (GlobalData.datacart.get(i).getBook().getId() == id && GlobalData.datacart.get(i).getCount()>1 ) {
						GlobalData.datacart.get(i).setCount(GlobalData.datacart.get(i).getCount() - 1);
						count= GlobalData.datacart.get(i).getCount();
					}
				}

				
			

				Object[] object= {GlobalData.datacart.stream().mapToInt(DataCart::getCount).sum(),GlobalData.datacart.stream().mapToDouble(DataCart::totalPrice).sum(),count};

			return object;

		}
	@RequestMapping("shopList/removecart/{index}")
	public String removelistBookInCart(ModelMap model, @PathVariable("index") int index) {

		GlobalData.datacart.remove(index);

		return "redirect:/bookstore/cart";

	}

	@RequestMapping("shopList/clearcart")
	public String clearlistBookInCart(ModelMap model) {

		GlobalData.datacart.clear();

		return "redirect:/bookstore/cart";

	}
	@RequestMapping("shopList/cart/checkout")
	public String checoutkBookInCart(ModelMap model) {

		
		model.addAttribute("DatacartCount", GlobalData.datacart.stream().mapToInt(DataCart::getCount).sum());
		model.addAttribute("DatacartTotal", GlobalData.datacart.stream().mapToDouble(DataCart::totalPrice).sum());
		model.addAttribute("Datacart", GlobalData.datacart);
		return "checkout";

	}
}
