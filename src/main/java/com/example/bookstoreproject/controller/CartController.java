package com.example.bookstoreproject.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


        model.addAttribute("DatacartCount", GlobalDataCart.dataCarts.stream().mapToInt(DataCart::getCount).sum());
        model.addAttribute("DatacartTotal", GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum());
        model.addAttribute("Datacart", GlobalDataCart.dataCarts);
        return "cart";
    }

    @ResponseBody
    @RequestMapping("shopList/addcart/{id}")
    public Object[] listBookInCart(ModelMap model, @PathVariable("id") Long id) {

        DataCart data = new DataCart(bookService.findById(id).get(), 1);
        int step = 0;
        if (GlobalDataCart.dataCarts.size() == 0) {
            GlobalDataCart.dataCarts.add(data);

        } else {

            for (int i = 0; i < GlobalDataCart.dataCarts.size(); i++) {
                if (GlobalDataCart.dataCarts.get(i).getBook().getId() == id) {
                    GlobalDataCart.dataCarts.get(i).setCount(GlobalDataCart.dataCarts.get(i).getCount() + 1);
                }
            }

            for (int i = 0; i < GlobalDataCart.dataCarts.size(); i++) {
                if (GlobalDataCart.dataCarts.get(i).getBook().getId() != id) {
                    step += 1;
                }
            }
            if (step == GlobalDataCart.dataCarts.size()) {
                GlobalDataCart.dataCarts.add(data);

            }
        }

        Object[] object = {GlobalDataCart.dataCarts.stream().mapToInt(DataCart::getCount).sum(), GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum()};


        return object;

    }

    // tang so luong sach trong gio
    @ResponseBody
    @RequestMapping("shopList/cart/updatecart/{id}")
    public Object[] updateBookInCart(ModelMap model, @PathVariable("id") Long id) {

        DataCart data = new DataCart(bookService.findById(id).get(), 1);
        int step = 0;
        int count = 0;
        if (GlobalDataCart.dataCarts.size() == 0) {
            GlobalDataCart.dataCarts.add(data);

        } else {

            for (int i = 0; i < GlobalDataCart.dataCarts.size(); i++) {
                if (GlobalDataCart.dataCarts.get(i).getBook().getId() == id) {
                    GlobalDataCart.dataCarts.get(i).setCount(GlobalDataCart.dataCarts.get(i).getCount() + 1);
                    count = GlobalDataCart.dataCarts.get(i).getCount();
                }
            }

            for (int i = 0; i < GlobalDataCart.dataCarts.size(); i++) {
                if (GlobalDataCart.dataCarts.get(i).getBook().getId() != id) {
                    step += 1;
                }
            }
            if (step == GlobalDataCart.dataCarts.size()) {
                GlobalDataCart.dataCarts.add(data);

            }
        }

        Object[] object = {GlobalDataCart.dataCarts.stream().mapToInt(DataCart::getCount).sum(), GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum(), count};

        return object;

    }

    // giam so luong sach trong gio
    @ResponseBody
    @RequestMapping("shopList/cart/downUpdatecart/{id}")
    public Object[] downUpdateBookInCart(ModelMap model, @PathVariable("id") Long id) {
        int count = 0;
        for (int i = 0; i < GlobalDataCart.dataCarts.size(); i++) {
            if (GlobalDataCart.dataCarts.get(i).getBook().getId() == id && GlobalDataCart.dataCarts.get(i).getCount() > 1) {
                GlobalDataCart.dataCarts.get(i).setCount(GlobalDataCart.dataCarts.get(i).getCount() - 1);
                count = GlobalDataCart.dataCarts.get(i).getCount();
            }
        }


        Object[] object = {GlobalDataCart.dataCarts.stream().mapToInt(DataCart::getCount).sum(), GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum(), count};

        return object;

    }

    @RequestMapping("shopList/removecart/{index}")
    public String removelistBookInCart(ModelMap model, @PathVariable("index") int index) {

        GlobalDataCart.dataCarts.remove(index);

        return "redirect:/bookstore/cart";

    }

    @RequestMapping("shopList/clearcart")
    public String clearlistBookInCart(ModelMap model) {

        GlobalDataCart.dataCarts.clear();

        return "redirect:/bookstore/cart";

    }

    @ModelAttribute("DatacartCount")
    public int DataCartCount() {
        return GlobalDataCart.dataCarts.stream().mapToInt(DataCart::getCount).sum();
    }


    @ModelAttribute("DatacartTotal")
    public double DatacartTotal() {
        return GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum();
    }


    @ModelAttribute("Datacart")
    public List<DataCart> Datacart() {
        return GlobalDataCart.dataCarts;
    }


    @RequestMapping("shopList/cart/checkout")
    public String checkOutBookInCart() {


//        model.addAttribute("DatacartCount", GlobalDataCart.dataCarts.stream().mapToInt(DataCart::getCount).sum());
//        model.addAttribute("DatacartTotal", GlobalDataCart.dataCarts.stream().mapToDouble(DataCart::totalPrice).sum());
//        model.addAttribute("Datacart", GlobalDataCart.dataCarts);
        return "checkout";

    }
}
