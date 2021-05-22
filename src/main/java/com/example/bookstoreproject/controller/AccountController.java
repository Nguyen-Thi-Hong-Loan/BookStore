package com.example.bookstoreproject.controller;


import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AccountController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserEntity userDTO() {
        return new UserEntity();
    }
    @RequestMapping("profile")
    public String listPost(ModelMap model, Principal principal) {

        User user = (User) ((Authentication) principal).getPrincipal();
        UserEntity userEntity = userService.findByEmail(user.getUsername());
        model.addAttribute("profile", userEntity);

        return "userProfile";
    }

    @GetMapping("updateUser")
    public String updateUser() {
        return "updateUser";
    }


}
