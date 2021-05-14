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
//		model.addAttribute("cartCount", GlobalData.cart.size());
//		model.addAttribute("cartTotal", GlobalData.cart.stream().mapToDouble(BookEntity::getPrice).sum());
//		model.addAttribute("cart", GlobalData.cart);

		model.addAttribute("DatacartCount", GlobalData.datacart.stream().mapToInt(DataCart::getCount).sum());
		model.addAttribute("DatacartTotal", GlobalData.datacart.stream().mapToDouble(DataCart::totalPrice).sum());
		model.addAttribute("Datacart", GlobalData.datacart);
		return "cart";
	}

	@RequestMapping("shopList/addcart/{id}")
	public String listBookInCart(ModelMap model, @PathVariable("id") Long id) {

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

//		GlobalData.cart.add(bookService.findById(id).get());

		return "redirect:/bookstore/shopList";

	}
	
	// tang so luong sach trong gio
	@RequestMapping("shopList/cart/updatecart/{id}")
	public String updateBookInCart(ModelMap model, @PathVariable("id") Long id) {

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



		return "redirect:/bookstore/cart";

	}
	// giam so luong sach trong gio
		@RequestMapping("shopList/cart/downUpdatecart/{id}")
		public String downUpdateBookInCart(ModelMap model, @PathVariable("id") Long id) {

				for (int i = 0; i < GlobalData.datacart.size(); i++) {
					if (GlobalData.datacart.get(i).getBook().getId() == id && GlobalData.datacart.get(i).getCount()>1 ) {
						GlobalData.datacart.get(i).setCount(GlobalData.datacart.get(i).getCount() - 1);
					}
				}

				
			



			return "redirect:/bookstore/cart";

		}
	@RequestMapping("shopList/removecart/{index}")
	public String removelistBookInCart(ModelMap model, @PathVariable("index") int index) {

		GlobalData.datacart.remove(index);

		return "redirect:/bookstore/cart";

	}

	@RequestMapping("shopList/clearcart")
	public String clearlistBookInCart(ModelMap model) {

		GlobalData.datacart.clear();
		;

		return "redirect:/bookstore/cart";

	}

}
