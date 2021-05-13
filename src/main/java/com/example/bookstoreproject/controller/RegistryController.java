package com.example.bookstoreproject.controller;


import com.example.bookstoreproject.entity.RoleEntity;
import com.example.bookstoreproject.entity.UserEntity;
import com.example.bookstoreproject.services.RoleService;
import com.example.bookstoreproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/bookstore")
public class RegistryController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @ModelAttribute("user")
    public UserEntity userEntity() {
        return new UserEntity();
    }

    @GetMapping("register")
    public String register(Model model) {
        return "registry";
    }


    @PostMapping("registerNow")
    public String registerUserAccount(@ModelAttribute("user") UserEntity entity) {

        RoleEntity roleEntity = roleService.findByRoleName("ROLE_USER");

        entity.setRoles(Arrays.asList(roleEntity));


        userService.save(entity);
        return "redirect:/bookstore/register?success";
    }

    @PostMapping("/checkEmail")
    @ResponseBody
    public String check(@RequestParam String email) {
        return (userService.findByEmail(email) != null ? "exist" : "ok");
    }
}
