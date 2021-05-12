package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.services.PaypalService;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaypalController {

//    @Autowired
//    private PaypalService service;
    @Autowired
    private UserService userService;

    public static final String SUCCESS_URL = "/pay/success";
    public static final String CANCEL_URL = "/pay/cancel";
    private double price = 0;

    @GetMapping("/paypal")
    public String homePayPal() {
        return "paypalHome";

    }

}
