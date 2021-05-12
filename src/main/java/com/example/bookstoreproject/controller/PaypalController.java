package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.services.PaypalService;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaypalController {

//    @Autowired
//    private PaypalService service;
    @Autowired
    private UserService userService;
}
