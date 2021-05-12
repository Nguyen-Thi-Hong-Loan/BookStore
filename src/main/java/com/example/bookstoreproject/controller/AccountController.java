package com.example.bookstoreproject.controller;


import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AccountController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserEntity userDTO() {
        return new UserEntity();
    }


}
